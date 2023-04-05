package sk000801.복습;

//10분??
class Solution {
    //진법 n, 미리 구할 숫자개수 t, 게임 참가 인원 m, 튜브 순서 p
    //t가 그거다 결과 값의 문자열 길이
    public String solution(int n, int t, int m, int p) {
        int idx = 0;
        String s = "";
        String answer = "";
        while(s.length() <= t*m+p) {
            s += Integer.toString(idx, n);
            idx++;
        }
        for(int i = 0; i < t; i++) {
            answer += Character.toString(s.charAt(i*m+p));
        }
        return answer.toUpperCase();
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 4, 2, 1));
    }
}