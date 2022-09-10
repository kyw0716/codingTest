package sk000801;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int root = (int) Math.sqrt(n);
        if(n==1) return 1; 
        if(Math.sqrt(n)- root == 0) {
            for(int i=1; i<=root; i++) {
                if(n%i==0) {
                    if(i == root) {
                        answer += i;
                        continue;
                    }
                    else {
                        answer += i;
                    answer += n/i;
            }
            }
        }
        }
        else {
            for(int i=1; i<=root; i++) { 
           if(n%i==0) {
                answer += i;
                answer += n/i;
            }
        }
        }
        
        return answer;
    }
}
