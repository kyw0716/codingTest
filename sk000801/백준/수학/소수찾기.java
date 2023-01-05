package sk000801.백준.수학;
import java.util.*;

public class 소수찾기 {
    public static boolean sosu(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int count = 0;
        for(int i = 1; i <= n; i++) {
            int a = in.nextInt();
            if(a == 1) continue;
            if(sosu(a)) count++;
        }

        System.out.println(count);
    }
    
}
