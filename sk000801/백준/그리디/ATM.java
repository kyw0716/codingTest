package sk000801.백준.그리디;
import java.util.*;

public class ATM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);

        int answer = 0;
        for(int i = 0; i < n; i++) {
            answer += num[i]*(n-i);
        }

        System.out.println(answer);
    }
}
