package sk000801.백준.bfs연습;
import java.util.*;

public class 촌수계산 {
    static int n;
    static int[][] people;
    static int[] result;
    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int a, int b) {
        q.add(a);

        while(!q.isEmpty()) {
            int we = q.poll();

            if(we==b) return;
            for(int i = 1; i <= n; i++) {
                if(result[i] == 0 && people[we][i] == 1) {
                    q.add(i);
                    result[i] = result[we]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        people = new int[n+1][n+1];
        result = new int[n+1];

        int a1 = in.nextInt();
        int a2 = in.nextInt();

        int pac = in.nextInt();
        for(int i = 1; i <= pac; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            people[a][b] = 1;
            people[b][a] = 1;
        }

        bfs(a1, a2);
        int ans = result[a2] == 0 ? -1 : result[a2];
        System.out.println(ans);        
    }
}
