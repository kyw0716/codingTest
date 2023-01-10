package sk000801.백준.그리디;
import java.util.*;

public class 전자레인지 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int a = 0;
        int b = 0;
        int c = 0;

        a = n/300;
        n -= a*300;
        b = n/60;
        n -= b*60;
        c = n/10;
        n -= c*10;

        if(n != 0) System.out.println(-1);
        else System.out.println(a+" "+b+" "+c);
    }
}
