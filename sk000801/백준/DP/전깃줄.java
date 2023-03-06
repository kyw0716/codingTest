package sk000801.백준.DP;
import java.io.*;
import java.util.*;

public class 전깃줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            line[i][0] = Integer.parseInt(s[0]);
            line[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(line, new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });

        for(int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        //기준점으로부터 오른쪽(더 큰 값들) 탐색?
        for(int i = n-1; i >= 0; i--) {
            for(int j = i+1; j < n; j++) {
                if(line[i][1] < line[j][1] && dp[i] <= dp[j]) dp[i] = dp[j]+1;
            }
        }
        Arrays.sort(dp);

        System.out.println(n-dp[n-1]);
    }
}
