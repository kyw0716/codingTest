import java.math.*;
class Solution {
    public BigInteger fac(int a) {
        BigInteger ans = new BigInteger("1");
        for(int i = 2; i <= a; i++) {
            ans = ans.multiply(BigInteger.valueOf(i));
        }
        return ans;
    }
    public BigInteger solution(int balls, int share) {
        return fac(balls).divide((fac(share).multiply(fac(balls-share))));
    }
}