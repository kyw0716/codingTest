package sk000801.백준.복습;
import java.io.*;

//17분
//아마도 처음에 풀었던 m을 활용한 풀이는 m의 시간 복잡도에 의해 불가능할듯
//(시간 초과가 난 거 같음)
//그래서 n을 활용해서 dp로 미리 정해진 범위의 값을 구하는 거 같다
public class 팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder("");

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[][] dp = new int[n][n];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                dp[i][j] = -1;
                for(int r = 0; r <= (j-i)/2; r++) {
                    if(num[i+r] != num[j-r]) dp[i][j] = 0;
                }
                if(dp[i][j] != 0) dp[i][j] = 1;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0])-1;
            int b = Integer.parseInt(s[1])-1;
            sb.append(dp[a][b]).append("\n");
        }
        System.out.println(sb);
    }
}
