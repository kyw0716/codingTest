package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

public class 로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];

        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(num);

        int max = 0;
        for(int i = 1; i <= n; i++) {
            int num2 = (n-i+1)*num[i];
            if(num2>max) max = num2;
        }

        System.out.println(max);
    }
}
