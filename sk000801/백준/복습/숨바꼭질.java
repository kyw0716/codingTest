package sk000801.백준.복습;
import java.util.*;

//초기값을 1로 설정해줘야 값이 맞게 돌아가네ㅠㅠ
//만약 처음 n값이 0이라면 *2가 마지막으로 들어가야 함?
public class 숨바꼭질 {
    static int n,k;
    static int sec = 0;
    static int[] visited;
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);

        while(!q.isEmpty()) {
            int top = q.poll();

            for(int i = 0; i < 3; i++) {
                int next = 0;
                if(i==0) next = top*2;
                if(i==1) next = top+1;
                if(i==2) next = top-1;

                if(next == k) {
                    sec = visited[top];
                    return;
                }

                if(next >= 0 && next <= 100000 && visited[next] == 0) {
                    visited[next] = visited[top]+1;
                    q.add(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        visited = new int[100001];

        if(n==k) {System.out.println(0); return;}

        bfs(n);

        System.out.println(sec);
    }
}
