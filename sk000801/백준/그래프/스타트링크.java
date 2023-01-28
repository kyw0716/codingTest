package sk000801.백준.그래프;
import java.util.*;

public class 스타트링크 {
    static int all;
    static int dest;
    static int up;
    static int down;
    static int[] visited;

    public static void bfs(int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = 1;

        while(!q.isEmpty()) {
            int top = q.poll();
            if(top==dest) {System.out.println(visited[top]-1); return;}

            if(top+up <= all && visited[top+up] == 0) {
                visited[top+up] = visited[top]+1;
                q.add(top+up);
            }
            if(top-down >= 1 && visited[top-down] == 0) {
                visited[top-down] = visited[top]+1;
                q.add(top-down);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(in.nextLine());

        all = Integer.parseInt(st.nextToken());
        visited = new int[all+1];
        int cur = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());
        up = Integer.parseInt(st.nextToken());
        down = Integer.parseInt(st.nextToken());

        if(dest==cur) {System.out.println(0); return;}

        bfs(cur);

        if(visited[dest] == 0){System.out.println("use the stairs");}
    }
}
