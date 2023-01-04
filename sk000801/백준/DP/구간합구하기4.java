package sk000801.백준.DP;
import java.io.*;

public class 구간합구하기4 {
    //누적합 이용!
    //입력받은 인덱스 두개 (큰거-(작은거-1)) 누적합 값 빼주기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] num = new int[n+1];
        int[] sum = new int[n+1];
        String[] s2 = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(s2[i-1]);
        }

        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i-1]+num[i];
        }

        for(int j = 0; j < m; j++) {
            String[] s3 = br.readLine().split(" ");
            int one = Integer.parseInt(s3[0]);
            int two = Integer.parseInt(s3[1]);
            System.out.println(sum[two]-sum[one-1]);
        }
    }
    
}
