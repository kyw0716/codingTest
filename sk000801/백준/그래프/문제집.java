package sk000801.백준.그래프;
import java.util.*;

//13분 => 위상정렬(indegree, priorityQueue)을 알면 바로 풀 수 있다!
//번호가 곧 난이도 순서
public class 문제집 {
    static int n;
    static List<List<Integer>> priority;
    static int[] indegree;
    //각 인덱스 안에 담긴 번호가 먼저 풀어야 하는 문제번호
    public static int[] bfs() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int[] order = new int[n];
        int idx = 0;

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) pq.add(i);
        }

        while(!pq.isEmpty()) {
            int cur = pq.poll();
            order[idx++] = cur;

            for(int i = 0; i < priority.get(cur).size(); i++) {
                int num = priority.get(cur).get(i);

                indegree[num]--;

                if(indegree[num] == 0) pq.add(num);
            }
        }

        return order;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        priority = new ArrayList<>();
        indegree = new int[n+1];

        for(int i = 0; i <= n; i++) {
            priority.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            priority.get(a).add(b);
            indegree[b]++;
        }

        int[] ans = bfs();
        for(int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
