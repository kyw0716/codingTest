import java.util.*;

public class 퇴사 {
    static int N;
    static int[] t;
    static int[] p;
    static int max = 0;

    public static void dfs(int index, int sum) {
        if(index >= N) {max = Math.max(max, sum);return;}
        
        //주어진 index가 포함된 부분
        if(index+t[index] <= N) dfs(index+t[index], sum+p[index]);
        else dfs(index+t[index], sum);

        //다음 index로 넘어간 부분
        dfs(index+1, sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        t = new int[N+1];
        p = new int[N+1];

        for(int i = 0; i < N; i++) {
            t[i] = in.nextInt();
            p[i] = in.nextInt();
        }

        dfs(0, 0); //인덱스 0부터, 0까지

        System.out.println(max);
    }
}
        //DP(동적 프로그래밍)
        // Scanner in = new Scanner(System.in);
        // int N = in.nextInt();
        // int[] T = new int[N+10];
        // int[] P = new int[N+10];
        // int[] DP = new int[N+10];
        // int max = 0;

        // for(int i = 0; i < N; i++) {
        //     T[i] = in.nextInt();
        //     P[i] = in.nextInt();
        // }

        // for(int i = 0; i <= N; i++) {
        //     DP[i] = Math.max(DP[i], max);
        //     DP[T[i]+i] = Math.max(DP[T[i]+i], P[i]+DP[i]);
        //     max = Math.max(max, DP[i]);
        // }

        // System.out.println(max);