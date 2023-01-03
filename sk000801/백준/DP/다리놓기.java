package sk000801.백준.DP;
import java.io.*;
import java.math.BigInteger;

public class 다리놓기 {
    public static BigInteger fact(int c) {
        BigInteger i = BigInteger.ONE;
        for(int j = 2; j <= c; j++) {
            BigInteger jj = new BigInteger(String.valueOf(j));
            i = i.multiply(jj);
        }
        return i;
    }
    public static BigInteger com(int c, int r) {
        BigInteger a = fact(r);
        BigInteger b = fact(c);
        BigInteger cc = fact(r-c);
        return a.divide(b.multiply(cc));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Math.max(a, b);
            int r = Math.min(a, b);
            System.out.println(com(r, c));
        }
    }
}
