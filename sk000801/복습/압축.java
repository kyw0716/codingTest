package sk000801.복습;
import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String> alpha = new ArrayList<>();
        List<String> num = new ArrayList<>();

        for(int i = 0; i < 26; i++) {
            alpha.add(Character.toString((char)65+i));
        }

        String[] s = msg.split("");
        String temp = "";
        int idx = 0;

        while(idx <= s.length-1) {
            temp += s[idx];
            if(alpha.contains(temp)) {
                if(idx == s.length-1) num.add(temp);
                idx++;
            } else {
                num.add(temp.substring(0, temp.length()-1));
                alpha.add(temp);
                temp = "";
            }
        }

        int[] answer = new int[num.size()];
        for(int i = 0; i < num.size(); i++) {
            for(int j = 0; j < alpha.size(); j++) {
                if(num.get(i).equals(alpha.get(j))) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String msg = "TOBEORNOTTOBEORTOBEORNOT";
        s.solution(msg);
    }
}