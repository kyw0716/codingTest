package sk000801.백준.그리디;
import java.util.*;

public class 주유소 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        long[] load = new long[n-1];
        long[] price = new long[n];
        long answer = 0;

        for(int i = 0; i < n-1; i++) {
            load[i] = in.nextLong();
        }
        for(int i = 0; i < n; i++) {
            price[i] = in.nextLong();
        }

        long temp = price[0];
        for(int i = 0; i < n-1; i++) {
            if(price[i] < temp) temp = price[i];
            answer += temp*load[i];
        }

        System.out.println(answer);
    }
}
