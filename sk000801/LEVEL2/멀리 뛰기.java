class Solution {
    public long solution(int n) {
        long[] pibo = new long[n+1];
        pibo[0] = 1;
        pibo[1] = 2;
        for(int i = 2; i < n; i++) {
            pibo[i] = (pibo[i-1]+pibo[i-2])%1234567;
        }
        return pibo[n-1];
    }
}