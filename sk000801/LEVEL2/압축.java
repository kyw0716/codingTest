package sk000801.LEVEL2;
import java.util.*;
class Solution { //A=65 -> 1로
    public int[] solution(String msg) {
        String[] s = msg.split("");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            list.add(Character.toString((char)65+i));
        }
        int idx = 0;
        String temp = "";
        while(idx <= s.length-1) {
            temp += s[idx];
            if(list.contains(temp)) {
                if(idx == s.length-1) ans.add(temp);
                idx++;  
            } else {
                ans.add(temp.substring(0, temp.length()-1));
                list.add(temp);
                temp = "";
            }
        }
        //System.out.println(list);
        int[] answer = new int[ans.size()];
        // System.out.println(ans);

        for(int j = 0; j < ans.size(); j++) {
            for(int r = 0; r < list.size(); r++) {
                    if(ans.get(j).equals(list.get(r))) {answer[j] = r+1; break;}
            }
        }
        return answer;
    }
}
