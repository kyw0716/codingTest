package sk000801.복습;
import java.util.*;

//그때도 처음엔 순열로 구하려고 했는데
//20! 까지 올라가서 규칙을 찾아야 했던 듯
//이건 또 다시 풀어보겠다!!!!
public class 줄서는방법 {
    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> num = new ArrayList<>();
        long fact = 1;
        int idx = 0;

        for(int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }

        k--;
        while(n > 0) {
            fact /= n;
            int val = (int) (k / fact);
            answer[idx] = num.get(val);
            num.remove(val);

            k %= fact;
            idx++;
            n--;
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 3; int k = 5;
        int[] ans = solution(n, k);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
