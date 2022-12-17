class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(i*i == n) answer++;
            else if(n%i==0) answer += 2;
        }
        return answer;
    }
}