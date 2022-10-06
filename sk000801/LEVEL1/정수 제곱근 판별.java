class Solution {
    public long solution(long n) {
        int n1 = (int) Math.sqrt(n);
        long answer = -1;
        if(Math.sqrt(n)-n1 == 0) answer = (long) Math.pow(Math.sqrt(n)+1,2);
        return answer;
    }
}