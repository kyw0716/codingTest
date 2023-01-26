package sk000801.백준.DP;
import java.math.BigInteger;
import java.util.*;

public class 이항계수2 {

    public static BigInteger fact(int i) {
        BigInteger ans = BigInteger.ONE;
        for(int j = 2; j <= i; j++) {
            BigInteger num = new BigInteger(String.valueOf(j));
            ans = ans.multiply(num);
        }
        return ans;
    }
    public static int comb(int n, int m) {
        BigInteger bunmo = fact(m).multiply(fact(n-m));
        BigInteger ans = fact(n).divide(bunmo);
        ans = ans.remainder(BigInteger.valueOf(10007));
        return Integer.parseInt(ans.toString());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        System.out.println(comb(n, m));
    }
}


// 5 2 -> 5!/(3!*2!) -> 10 
// 6 2 -> 6!/(2!*4!) -> 15
// 

