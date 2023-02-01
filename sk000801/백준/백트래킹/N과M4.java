package sk000801.백준.백트래킹;
import java.util.*;

public class N과M4 {
    static int n, m;
    static int[] num;
    static StringBuffer sb = new StringBuffer("");

    public static boolean check(int[] num) {
        for(int i = 0; i < num.length-1; i++) {
            if(num[i] > num[i+1]) return false;
        }
        return true;
    }

    public static void dfs(int depth) {
        if(depth==m) {
            if(check(num)){
                for(int i = 0; i < m; i++) {
                    sb.append(num[i]+" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 1; i <= n; i++) {
            num[depth] = i;
            dfs(depth+1);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        num = new int[m];

        dfs(0);

        System.out.println(sb);
    }   
}
