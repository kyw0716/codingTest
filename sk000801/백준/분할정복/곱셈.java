package sk000801.백준.분할정복;
import java.util.*;

//https://www.acmicpc.net/problem/1629
//분할 정복을 활용한 거듭제곱 값 구하는 알고리즘
//짝수는 a^n = a^n/2 * a^n/2
//홀수는 a^n = a^(n-1)/2*a^(n-1)/2*a
public class 곱셈 {
    static long a,b,c;
    public static long pow(long x, long y) {
        if(y == 1) return x%c;
        else {
            long recur = pow(x, y/2);
            if(y%2==0) return recur*recur%c;
            else return (recur*recur%c*x)%c;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        long ans = pow(a, b);
        System.out.println(ans);
    }
}
