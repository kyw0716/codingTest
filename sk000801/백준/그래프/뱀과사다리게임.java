package sk000801.백준.그래프;
import java.util.*;

public class 뱀과사다리게임 {
    static int n, m;
    static int[] dist = new int[101];
    static int[] move = new int[101];

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        dist[1] = 0;
        q.add(1);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int i = 1; i <= 6; i++) {
                int next = cur+i;
                if(next > 100) break;

                next = move[next];
                if(dist[next] == -1) {
                    dist[next] = dist[cur]+1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();

        for(int i = 1; i <= 100; i++) {
            move[i] = i;
            dist[i] = -1;
        }

        for(int i = 0; i < n; i++) {
            int original = in.nextInt();
            int next = in.nextInt();
            move[original] = next;    
        }

        for(int i = 0; i < m; i++) {
            int original = in.nextInt();
            int next = in.nextInt();
            move[original] = next;
        }

        bfs();

        System.out.println(dist[100]);
    }
}
