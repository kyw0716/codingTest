package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 수리공항승 {
    static int n, len;
    static int[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        len = Integer.parseInt(s[1]);
        pos = new int[n];

        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            pos[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(pos);

        int ans = 0;
        int val = 0;
        for(int i = 0; i < n-1; i++) {
            val += Math.abs(pos[i+1]-pos[i]);
            if(len <= val) {
                ans++;
                val = 0;
            }
        }

        System.out.println(ans+1);
    }
}
