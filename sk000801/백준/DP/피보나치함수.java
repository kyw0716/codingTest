package sk000801.백준.DP;
import java.io.*;

public class 피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] one = new long[41];
        long[] zero = new long[41];
        one[0] = 0;
        one[1] = 1;
        zero[0] = 1;
        zero[1] = 0;

        for(int i = 2; i <= 40; i++) {
            zero[i] = zero[i-1]+zero[i-2];
            one[i] = one[i-1]+one[i-2];
        }

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int a = Integer.parseInt(br.readLine());

            System.out.println(zero[a]+ " " + one[a]);
        }
    }
}
