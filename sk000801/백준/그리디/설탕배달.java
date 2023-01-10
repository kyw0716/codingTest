package sk000801.백준.그리디;
import java.util.*;

public class 설탕배달 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int answer = 5000;

        for(int i = 0; i <= n/5; i++) {
            for(int j = 0; j <= n/3; j++) {
                if(5*i+3*j==n) {
                    answer = Math.min(i+j, answer);
                }
            }
        }

        if(answer==5000) System.out.println(-1);
        else System.out.println(answer);
    } 
}
