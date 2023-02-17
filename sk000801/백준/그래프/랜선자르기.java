package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//이분탐색...
public class 랜선자르기 {
    static int k, n;
    static long[] rans;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        k = Integer.parseInt(s[0]);
        rans = new long[k];
        n = Integer.parseInt(s[1]);

        long max = 0;
        for(int i = 0; i < k; i++) {
            rans[i] = Integer.parseInt(br.readLine());
            if(max < rans[i]) max = rans[i];
        }
        Arrays.sort(rans);

        max++;
        //최대길이+1을 최댓값으로 잡아 아래에서 mid가 0으로 나눠지는 문제 방지

        long first = 0;
        long mid = 0;

        while(first < max) {
            mid = (max+first)/2;

            long cnt = 0;
            for(int i = 0; i < k; i++) {
                cnt += rans[i]/mid;
            }
            if(cnt<n) max = mid;
            else first = mid+1;
        }

        System.out.println(first-1);
    }
}
