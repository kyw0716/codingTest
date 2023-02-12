package sk000801.백준.복습;
import java.util.*;

public class _NQueen {
    static int n;
    static int[] queen;
    static int count = 0;
    public static boolean right(int depth) {
        for(int i = 0; i < depth; i++) {
            if(queen[depth] == queen[i]) return false;
            if(Math.abs(depth-i) == Math.abs(queen[depth]-queen[i])) return false;
        }
        return true;
    }
    public static void dfs(int depth) {
        if(depth == n) {
            count++;
            return;
        }

        for(int i = 0; i < n; i++) {
            queen[depth] = i;

            if(right(depth)) dfs(depth+1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        queen = new int[n];

        dfs(0);

        System.out.println(count);
    }
}
