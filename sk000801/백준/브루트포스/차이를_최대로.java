import java.util.*;

public class 차이를_최대로 {
    static int n;
    static int[] num;
    static int max;

    public static void dfs(int depth) {
        if(depth == n) {
            int hap = 0;
            for(int i = 0; i < n-1; i++) {
                hap += Math.abs(num[i+1]-num[i]);
            }
            max = Math.max(hap, max);
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(i, depth);
            dfs(depth+1);
            swap(i, depth);
        }
    }
    public static void swap(int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        num = new int[n];
        max = 0;

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        dfs(0);

        System.out.println(max);
    }
}
