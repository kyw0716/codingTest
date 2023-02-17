package sk000801.백준.복습;
import java.util.*;

//메모리 초과가 발생했다는..
//그래서 원래 풀 때 노드로 풀었나보다..
public class 숨바꼭질3 {
    static int n, k;
    static int[] visited = new int[100_001];
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()) {
            int top = q.poll();

            if(top == k) return;

            for(int i = 0; i < 3; i++) {
                int next = top;

                if(i==0) next *= 2; 
                if(i==1) next += 1; 
                if(i==2) next -= 1; 

                if(next>=0 && next<=100_000 && visited[next] == 0) {
                    if(next / top == 2) visited[next] = visited[top];
                    else visited[next] = visited[top]+1;
                }

                q.add(next);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        k = in.nextInt();

        if(n==k) {System.out.println(0); return;}

        bfs(n);

        System.out.println(visited[k]);
    }
}
