import java.util.ArrayList;
class Solution {
    public int solution(int n) {
        ArrayList<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);
        for(int i=2; i<=n; i++) {
            fibo.add((fibo.get(i-2)+fibo.get(i-1))%1234567);
        }
        int answer = fibo.get(n);
        return answer;
    }
}