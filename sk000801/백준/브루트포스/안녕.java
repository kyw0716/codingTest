import java.util.*;

public class 안녕 {
    static int[] happy;
    static int[] lose;
    static int n;
    static int max;
    public static void dfs(int hap, int los, int depth, int index) {
        if(index == n) {
            if(los > 0 && depth != 0) {
                max = Math.max(max, hap);
            }
            return;
        }

        dfs(hap+happy[index], los-lose[index], depth+1, index+1);
        dfs(hap, los, depth, index+1);
    }
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        happy = new int[n];
        lose = new int[n];
        
        for(int i = 0; i < n; i++) {
            lose[i] = in.nextInt();
        }
        for(int i = 0; i < n; i++) {
            happy[i] = in.nextInt();
        }

        dfs(0, 100, 0, 0);

        System.out.println(max);
    }    
}
