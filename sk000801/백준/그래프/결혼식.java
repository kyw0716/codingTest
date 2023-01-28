package sk000801.백준.그래프;
import java.util.*;

public class 결혼식 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        int n = Integer.parseInt(in.nextLine());
        int[] visited = new int[n+1];
        int m = Integer.parseInt(in.nextLine());

        for(int i = 0; i <= n; i++) {
            node.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            String[] s = in.nextLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            node.get(a).add(b);
            node.get(b).add(a);
        }



        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 0;

        while(!q.isEmpty()) {
            int top = q.poll();

            for(int i = 0; i < node.get(top).size(); i++) {
                int next = node.get(top).get(i);
                if(visited[next] == 0) {
                    visited[next] = visited[top]+1;
                    q.offer(next);
                }
            }
        }

        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(visited[i] == 1 || visited[i] == 2) count++;
        }

        System.out.println(count);
    }
}
