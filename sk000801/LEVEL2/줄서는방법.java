package sk000801.LEVEL2;
import java.util.*;

//18분 보다가 GG
//순열인 줄 알았지만 n이 20이기 때문에 시간 초과 무조건 발생
//그래서 적절히 계산을 하여 k에 따른 처음 시작하는 숫자를 구해줘야함
class Solution {
    public int[] solution(int n, long k) {
        List<Integer> num = new ArrayList<>();
        int[] answer = new int[n];
        long fact = 1;
        int idx = 0;
        
        for(int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        
        k--;
        
        while(n>0) {
            fact /= n;
            int val = (int) (k/fact);
            answer[idx] = num.get(val);
            num.remove(val);
            
            k %= fact;
            idx++;
            n--;
        }
        return answer;
    }
}
