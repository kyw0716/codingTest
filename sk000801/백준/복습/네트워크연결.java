package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//최소 비용 => 우선순위 큐 + 방문처리
public class 네트워크연결 {
    static int n, m;
    static int answer = 0;
    static List<List<Computer>> list = new ArrayList<>();
    public static class Computer implements Comparable<Computer> {
        int node; int cost;

        public Computer(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Computer c) {
            return this.cost-c.cost;
        }
    }
    public static void bfs() {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(1, 0));

        int idx = 0;

        while(!pq.isEmpty()) {
            Computer cur = pq.poll();
            if(visited[cur.node]) continue;
            visited[cur.node] = true;
            answer += cur.cost;

            if(++idx == n) return;

            for(Computer next : list.get(cur.node)) {
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            list.get(a).add(new Computer(b, c));
            list.get(b).add(new Computer(a, c));
        }

        bfs();

        System.out.println(answer);
    }
}
