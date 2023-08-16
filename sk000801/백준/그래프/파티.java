package sk000801.백준.그래프;
import java.util.*;

//https://www.acmicpc.net/problem/1238
//50분 -> 바보같은 실수함(reverseList에 안담음)
public class 파티 {
    static int n, x;

    static class Node implements Comparable<Node>{
        int dest, val;
        Node(int dest, int val) {
            this.dest = dest;
            this.val = val;
        }
        @Override
        public int compareTo(Node n) {
            return val-n.val;
        }
    }
    public static int[] dijkstra(List<List<Node>> list) {
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(x, 0));

        int[] val = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(val, 1_000_000_000);
        val[x] = 0;

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int curDest = cur.dest;

            if(!visited[curDest]) {
                visited[curDest] = true;

                for(Node node : list.get(curDest)) {
                    if(!visited[node.dest] && val[node.dest] > val[curDest]+node.val) {
                        val[node.dest] = val[curDest]+node.val;
                        q.add(new Node(node.dest, val[node.dest]));
                    }
                }
            }
        }

        // for(int i = 1; i <= n; i++) {
        //     System.out.print(val[i]+" ");
        // }

        return val;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        x = in.nextInt();
        List<List<Node>> list = new ArrayList<>();
        List<List<Node>> reverse = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            int val = in.nextInt();
            list.get(from).add(new Node(to, val));
            reverse.get(to).add(new Node(from, val));
        }

        int[] val = dijkstra(list);
        int[] reverseVal = dijkstra(reverse);

        int answer = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            answer = Math.max(val[i]+reverseVal[i], answer);
        }

        System.out.println(answer);
    }
}
