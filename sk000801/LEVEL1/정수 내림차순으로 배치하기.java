import java.util.*;

class Solution {
    public long solution(long n) {
        int length = (int) (Math.log10(n)+1); 
        String answer[] = new String[length];
        for(int i=0; i<length; i++) {
            answer[i] =  String.valueOf(n%10);
            n /= 10;
        }
        Arrays.sort(answer, Collections.reverseOrder());
        String answer2 = "";
        for(String i : answer) {
            answer2 += i;
        }
        return Long.parseLong(answer2);
    }
}