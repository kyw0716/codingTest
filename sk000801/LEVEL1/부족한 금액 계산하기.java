package sk000801;


class Solution {
    public long solution(int price, int money, int count) {
        long answer=0;
        long total=0;
        for(long i=1; i<=count; i++) {
            total += i*price;
        }
       if(money<total) answer = total-money;
        return answer;
    }
}
