package sk000801.백준.그리디;
import java.io.*;
import java.util.StringTokenizer;

//뒤에서부터 탐색
//값이 작아질 때 최댓값-현재값 더해주기
//값이 커지면 최댓값을 갱신
//주어진 값이 크다면 변수형을 long으로 잡아두기
public class 주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] num = new int[n];
            long ans = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                num[j] = Integer.parseInt(st.nextToken());
            }

            int max = 0;
            for(int r = n-1; r >= 0; r--) {
                if(max < num[r]) max = num[r];
                else ans += max-num[r];
            }

            System.out.println(ans);
        }
    }
}
