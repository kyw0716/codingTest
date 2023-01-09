package sk000801.백준.bfs연습;
import java.util.*;
//처음 생각이 dfs로 3가지 경우 재귀 호출을 통해 풀어보려 했는데
//이게 i-1, i+1로 계속 호출이 되면 무한반복 되겠군.,. 그래서 안됐던 것,.,.

public class 숨바꼭질 {
    static int k;
    static int min;
    static int[] visited;
    static Queue<Integer> q = new LinkedList<>();

    public static void bfs(int i) {
        q.add(i);
        visited[i] = 1;

        while(!q.isEmpty()) {
            int num = q.poll();

            for(int j = 1; j <= 3; j++) {
                int next;
                if(j==1) next = num+1;
                else if(j==2) next = num-1;
                else next = num*2;

                if(next == k) {
                    min = visited[num];
                    return;
                }   

                if(next >= 0 && next < visited.length && visited[next] == 0) {
                    visited[next]  = visited[num]+1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        k = in.nextInt();
        visited = new int[100002];

        if(n==k) {System.out.println(0); return;}

        min = 0;
        bfs(n);

        System.out.println(min);
    }
}
