package sk000801.백준.복습;
import java.io.*;

//0~n까지의 값으로 각각 증가수열, 감소수열의 최댓값을 구함
// 둘을 합친 값이 가장 큰 결과가 이 문제의 정답
public class 가장긴바이토닉부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];
        int[] up = new int[n];
        int[] down = new int[n];

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s[i]);
        }

        for(int i = 0; i < n; i++) {
            int max = 0; //아마도 초기값을 0으로 두고 비교를 위해 마지막에 1을 더한듯?
            for(int j = 0; j < i; j++) {
                if(num[i] > num[j]) max = Math.max(max, up[j]);
            }
            up[i] = max+1;
        }

        for(int i = n-1; i >= 0; i--) {
            int max = 0;
            for(int j = n-1; j > i; j--) {
                if(num[i] > num[j]) max = Math.max(max, down[j]);
            }
            down[i] = max+1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans = Math.max(ans, up[i]+down[i]-1);
        }

        System.out.println(ans);
    }
}
