package sk000801.백준.DP;
import java.util.*;

public class 이친수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] ichin = new long[n+1];

        if(n==1) {System.out.println(1); return;}

        ichin[1] = 1;
        ichin[2] = 1;

        for(int i = 3; i <= n; i++) {
            ichin[i] = ichin[i-2]+ichin[i-1];
        }

        System.out.println(ichin[n]);
    }
}
