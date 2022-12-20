class Solution {
    public int fact(int n) {
        int answer = 1;
        for(int i = 1; i <= n; i++) {
            answer *= i;
        }
        return answer;
    }
    
    public int solution(int n) {
        int i = 1;
        while(fact(i) <= n) {
            i++;
        }
        return i-1;
    }
}