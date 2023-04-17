package sk000801.LEVEL2;
import java.util.*;

class Solution {
    //연속된 문자들 중 겹치는 문자를 압축해야함;;
    //정답 풀이들은 문자열을 반으로 쪼개 생각했는데 나는 
    //그냥 리스트에 쪼갠 문자열들을 담아놓고 주변 문자열을 비교하면서 정답 길이를 계산했는데
    //방식을 다시 생각해봐야할 거 같당,,
    // 45분+풀이 참조,,,
    public int solution(String s) {
        int ans = s.length();
        //압축을 시키기 위해 앞길이와 뒷길이가 적어도 같아야 하므로
        //길이의 반까지만 반복함
        for (int i = 1; i <= s.length() / 2; i++) {
            int len = 0;

            for(int j = 0; j + i <= s.length();){
                int h = j + i;
                int count = 1;
                String num = s.substring(j, j + i);

                while(h + i <= s.length() && num.equals(s.substring(h, h + i))){
                    h += i;
                    count ++;
                } 

                if(count == 1) len += i;
                else len += i + String.valueOf(count).length();  

                j = h;
            }

            if(s.length() % i != 0) len += s.length() % i; 
            ans = Math.min(ans, len);
        }

        return ans;
//         for(int i = 1; i < s.length(); i++) {
//             List<String> list = new ArrayList<>();
//             int idx = 0;
//             int len = 0;
//             while(idx+i <= s.length()) {
//                 String ss = s.substring(idx, idx+i);
//                 list.add(ss);
//                 idx += i;
//             }
//             System.out.println(list);
//             len += (s.length()%i==0 ? 0 : s.length()%i);
            
//             String temp = list.get(0);
//             int count = 1;
//             for(int j = 1; j < list.size(); j++) {
//                 if(temp.equals(list.get(j))) {
//                     count++;
//                 } else {
//                     len += (count > 1 ? i+String.valueOf(count).length() : i);
//                     temp = list.get(j);
//                     count = 1;
//                 }
//             }
//             min = Math.min(len, min);
//         }
//        return min;
    }
}