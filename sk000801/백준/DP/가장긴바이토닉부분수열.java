package sk000801.백준.DP;
import java.util.*;

//해당 인덱스까지의 긴 증가, 감소 부분 수열의 길이를 구해 더해서 최댓값 구하기
public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        int[] up = new int[n];
        int[] down = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        
        for(int i = 0; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(num[j] < num[i]) max = Math.max(max, up[j]);
            }
            up[i] = max+1;
        }
        for(int i = n-1; i >= 0; i--) {
            int max = 0;
            for(int j = n-1; j > i; j--) {
                if(num[j] < num[i]) max = Math.max(max, down[j]);
            }
            down[i] = max+1;
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            res = Math.max(res, up[i]+down[i]);
        }
  
        System.out.println(res-1);
    }
}

//반례
// 11
// 1 2 3 4 5 1 5 4 3 2 1
// 답 9

// 3
// 1 1 1
// 답 1