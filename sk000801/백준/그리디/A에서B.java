package sk000801.백준.그리디;
import java.util.*;

public class A에서B {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int count = 0;

        while(a != b) {
            if(b<a) {
                System.out.println(-1);
                return;
            }

            if(b%10 == 1) b /= 10;
            else if(b%2==0) b /= 2;
            else {
                System.out.println(-1);
                return;
            }
            count++;
        }

        System.out.println(count+1);
    }
}
