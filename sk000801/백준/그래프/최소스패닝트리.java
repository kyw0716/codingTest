package sk000801.백준.그래프;
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//내가 쓴 방법이 prim이라는데 잘 모르겠다,,
//https://www.acmicpc.net/problem/1197
public class 최소스패닝트리 {
    static int v,e;
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    public static class Node implements Comparable<Node>{
        int n, value;

        public Node(int n, int value) {
            this.n = n;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            return this.value-n.value;
        }
    }

    public static long cal() {
        boolean[] visited = new boolean[v+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //1번 노드
        pq.add(new Node(1, 0));
        
        long ans = 0;
        long idx = 0;

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(visited[n.n]) continue;

            ans += n.value;
            visited[n.n] = true;
            //노드의 끝까지 도달했다면 끝내야됨
            if(++idx == v) return ans; 

            for(int i = 0; i < tree.get(n.n).size(); i++) {
                Node next = tree.get(n.n).get(i);
                if(visited[next.n]) continue;
                pq.add(next);
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= v; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree.get(a).add(new Node(b, c));
            tree.get(b).add(new Node(a, c));
        }

        System.out.println(cal());
    }
}
