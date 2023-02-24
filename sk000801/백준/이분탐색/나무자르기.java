package sk000801.백준.이분탐색;
import java.io.*;
import java.util.*;

public class 나무자르기 {
    static int n;
    static long m;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Long.parseLong(s[1]);
        tree = new long[n];
        
        s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(tree);

        long start = 0;
        long fin = tree[n-1]+1;
        while(start < fin) {
            long min = (start+fin)/2;

            long cnt = 0;
            for(int i = 0; i < n; i++) {
                if(tree[i]-min>0) cnt += tree[i]-min;
            }
            if(cnt<m) fin = min;
            else start = min+1; 
        }

        System.out.println(start-1);
    }
}
