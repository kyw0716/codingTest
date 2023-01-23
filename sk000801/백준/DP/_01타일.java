package sk000801.백준.DP;
import java.util.*;

public class _01타일 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n+1];

        num[1] = 1;
        if(n==1) {System.out.println(num[1]); return;}
        num[2] = 2;

        for(int i = 3; i <= n; i++) {
            num[i] = (num[i-2]+num[i-1])%15746;
        }

        System.out.println(num[n]);
    }
}

//n=1 -> 1
//n=2 -> 2
//n=3 -> 111, 001, 100 -> 3
//n=4 -> 2+3