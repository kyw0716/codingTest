package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

public class 세수의합 {
    static int n;
    static long[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        num = new long[n];
        for(int i = 0; i < n; i++) {
            num[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(num);

        for(int x = n-1; x >= 0; x--) {
            for(int i = x-1; i >= 0; i--) {
                for(int j = x-1; j >= i; j--) {
                    if(num[i]+num[j] > num[x]) continue;
                    for(int r = x-1; r >= j; r--) {
                        long res = num[i]+num[j]+num[r];
                        if(res > num[x]) continue;
                        if(num[x] == res) {
                            System.out.println(res);
                            return;
                        }
                    }
                }
            }
        }
    }
}
