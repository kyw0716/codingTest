package sk000801.백준.그리디;
import java.io.*;

public class 동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        long k = Long.parseLong(s[1]);

        long[] num = new long[n+1];
        long answer = 0;
        for(int i = 1; i<= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = n; i >= 1; i--) {
            if(k==0) break;
            answer += k/num[i];
            k -= (k/num[i])*num[i];
        }

        System.out.println(answer);
    }
}
