package sk000801.백준.그래프;
import java.util.*;

public class 숨바꼭질3 {
    static boolean[] visited = new boolean[100001];
    static int k;
    static int min = 100000;
    public static class Node {
        int node, count;

        public Node(int node, int count) {
            this.node = node;
            this.count = count;
        }
    }
    public static void bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visited[start] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();
            if(n.node == k) min = Math.min(min, n.count);
            for(int i = 0; i < 3; i++) {
                int next = 0;
                if(i==0) next = n.node*2;
                if(i==1) next = n.node-1;
                if(i==2) next = n.node+1;

                if(next>=0 && next<=100000 && !visited[next]) {
                    if(i != 0) q.add(new Node(next, n.count+1));
                    else q.add(new Node(next, n.count));
                    visited[next] = true;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        k = in.nextInt();

        if(n==k) {System.out.println(0); return;}

        bfs(n);

        System.out.println(min);
    }
}
