package sk000801.백준.DP;
import java.io.*;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/12865
//배낭문제(무게, 가치) -> Knapsack 알고리즘
//세상 첨 들어봄 

public class 평범한배낭 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][k+1];
        int[][] mg = new int[n+1][2];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            mg[i][0] = Integer.parseInt(st.nextToken());
            mg[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(mg[i][0] <= j) { 
                    //최대무게(?) 보다 작을 때, 최대 무게를 점점 증가시킴 
                    if(mg[i][1] + dp[i-1][j-mg[i][0]] > dp[i-1][j]) 
                    //이전의 최대가치보다 현재 가치를 넣어주는게 최대가치가 크다면
                        dp[i][j] = mg[i][1]+dp[i-1][j-mg[i][0]];
                    else dp[i][j] = dp[i-1][j];
                    //아니면 이전 가치 그대로 현재 가치에 넣어줌
                }
                else dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
