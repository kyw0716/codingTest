import java.util.*;

public class 도영이가_만든_맛있는_음식 {

    static long min;
    static int n;
    static int[] s;
    static int[] b;

    public static void dfs(long gop, long hap, int index) {
        if(index == n) {
            min = Math.min(min, Math.abs(gop-hap));
            if(min == 0) return;
            return;
        }

        dfs(gop*s[index], hap+b[index], index+1);
        dfs(gop, hap, index+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        min = Long.MAX_VALUE;

        s = new int[n];
        b = new int[n];

        for(int i = 0; i < n; i++) {
            String[] ss = in.nextLine().split(" ");
            s[i] = Integer.parseInt(ss[0]);
            b[i] = Integer.parseInt(ss[1]);
        }

        if(n == 1) {
            System.out.println(Math.abs(s[0]-b[0]));
            return;
        }

        dfs(1, 0, 0);

        System.out.println(min);
    }
}
