package sk000801.백준.그리디;
import java.util.*;

public class 보물 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];

        for(int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        for(int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            answer += a[i]*b[n+1-i];
        }

        System.out.println(answer);
    }
}
