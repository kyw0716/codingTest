package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1967
public class 트리의지름 {
    static int n;
    static List<List<Node>> list = new ArrayList<>();
    public static class Node implements Comparable<Node> {
        int n; int dist;
        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
        @Override
        public int compareTo(Node n) {
            return this.dist-n.dist;
        }

    }
    public static int[] bfs(int start) {
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int num = q.poll();
            for(Node node : list.get(num)) {
                int jum = node.n;
                int geori = node.dist;

                if(!visited[jum]) {
                    visited[jum] = true;
                    dist[jum] = dist[num]+geori;
                    q.add(jum);
                }
            }
        }

        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        if(n==1) {
            System.out.println(0);
            return;
        }

        int[] dist = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        int idx = 0;
        //루트 번호는 항상 1이므로 1과 연결된 자식 노드부터 탐색 시작
        dist = bfs(1);
        for(int i = 2; i <= n; i++) {
            if(dist[idx] < dist[i]) idx = i;
        }

        dist = bfs(idx);
        Arrays.sort(dist);

        System.out.println(dist[n]);
    }
}
