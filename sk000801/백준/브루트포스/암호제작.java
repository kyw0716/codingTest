import java.util.*;
import java.math.BigInteger;

//시간초과!!!!!!!!!!!!!!!
public class Main {
    public static boolean isPrime(int n) {
        for(int i = 2; i < n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String P = in.next();
        String K = in.next();

        List<Integer> prime = new ArrayList<>();

        BigInteger p = new BigInteger(P);

       for(int i = 2; i < Integer.parseInt(K); i++) {
           if(isPrime(i)) prime.add(i);
        }

        for(int i = 0; i < prime.size(); i++) {
            BigInteger ii = new BigInteger(String.valueOf(prime.get(i)));
            BigInteger z = new BigInteger("0");
            if(p.divide(ii) == z) {
                if(prime.contains(prime.get(i))) {
                    System.out.println("BAD " + prime.get(i));
                    return;
                }
            } 
        }

        System.out.println("GOOD");
    }
}

//어떻게 하면 P까지 돌지 않으면 되는지 생각 해보기!!!