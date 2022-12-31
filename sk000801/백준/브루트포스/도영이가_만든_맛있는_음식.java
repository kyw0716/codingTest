import java.io.*;
import java.util.*;

public class 도영이가_만든_맛있는_음식 {

    static long min;
    static int n;
    static int[] s;
    static int[] b;

    public static void dfs(long gop, long hap, int depth, int index) {
        if(index == n) {
            if(depth != 0) min = Math.min(min, Math.abs(gop-hap));
            return;
        }

        dfs(gop*s[index], hap+b[index], depth+1, index+1);
        dfs(gop, hap, depth, index+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        min = Long.MAX_VALUE;

        s = new int[n];
        b = new int[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, 0, 0, 0);

        System.out.println(min);
    }
}
