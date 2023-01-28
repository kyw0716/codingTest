package sk000801.백준.그래프;
import java.util.*;
//https://www.acmicpc.net/problem/18352
//백준18352
//진짜 노드 탐색이라 다익스트라(아직 정확히 모름)나 플로이드로 풀고 싶었는데
//무난히 bfs로 풀기로 결정!
public class 특정거리의도시찾기 {
    static ArrayList<ArrayList<Integer>> node = new ArrayList<>();
    static int n,m,k,x;
    static int[] dist;
    public static void bfs() {
        dist[x] = 0; //시작점 x의 최단거리 값은 0
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()) {
            int top = q.poll();

            for(int i = 0; i < node.get(top).size(); i++) {
                int next = node.get(top).get(i);
                if(dist[next] == -1) {
                    dist[next] = dist[top]+1;
                    q.offer(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(in.nextLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n+1];

        for(int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
            //각각의 노드와 연결돼있는 모든 노드들을 담기 위한
            dist[i] = -1;
            //-1로 최솟값 초기화!
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(in.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node.get(a).add(b);
            //a->b로 향할 수 있다면 a의 리스트에 b를 담아줌
        }

        bfs();

        boolean answer = false;
        for(int i = 1; i <= n; i++) {
            if(dist[i] == k) {System.out.println(i); answer = true;}
        }
        if(!answer) System.out.println(-1);
    }
}
