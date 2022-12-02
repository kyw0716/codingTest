class Solution {
    
    public int countDivisors(int n) {
            int cnt = 0;
             for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    if (n / i == i) {
                        cnt++;
                    }
                    else {cnt += 2;}
                }
            }
            return cnt;
    }
         
    
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
           int divisor = countDivisors(i);
           if (divisor > limit) {
               answer += power;
           } else {
               answer += divisor;
           }
        }
        return answer;
    }
}