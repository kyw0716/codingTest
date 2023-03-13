package sk000801.LEVEL2;

class Solution {
    public String solution(int n, int t, int m, int p) {
        String all = "";
        int i = 0;
        while(all.length() < m*t+p) {
            all += Integer.toString(i, n);
            i++;
        }
        System.out.println(all);
        String answer = "";
        for(int j = 0; j < t; j++) {
            answer += Character.toString(all.charAt(m*j+p-1));
        }
        answer = answer.toUpperCase();
        
        return answer;
    }
}
