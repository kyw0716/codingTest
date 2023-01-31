package sk000801.백준.그리디;
import java.util.*;

public class 게임을만든동준이 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        for(int i = n-2; i >= 0; i--) {
            if(num[i+1]<=num[i]) {
                int chai = Math.abs(num[i]-num[i+1]+1);
                count += chai;
                num[i] -= chai;
            }
        }

        System.out.println(count);
    }
}
