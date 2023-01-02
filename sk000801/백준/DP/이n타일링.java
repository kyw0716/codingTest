package sk000801.백준.DP;
import java.util.*;

public class 이n타일링 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] block = new int[n+1];

        if(n==1) {
            System.out.println(1);
            return;
        }
        
        block[1] = 1;
        block[2] = 2;

        for(int i = 3; i <= n; i++) {
            block[i] = (block[i-1]+block[i-2])%10007;
        }

        System.out.println(block[n]);
    }
}
