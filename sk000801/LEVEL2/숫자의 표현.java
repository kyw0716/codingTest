class Solution {
    public int solution(int n) {
        int answer = 0;
        int d = 1;
        while(n>0) {
            if(n%d==0) answer++;
            n -= d;
            d++;
        }
        return answer;
    }
}