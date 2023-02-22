package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//'위상정렬'임을 알고 가는 문제
public class ACMCraft {
    static int n, k;
    static int[] time;
    static int[] indegree;
    static List<List<Integer>> list;
    static int[] answer;
    static StringBuffer sb = new StringBuffer("");
    public static void find() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for(Integer next : list.get(node)) {
                indegree[next]--;
                if(indegree[next] == 0) q.add(next);

                answer[next] = Math.max(answer[next], answer[node]+time[node]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            list = new ArrayList<>();
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            k = Integer.parseInt(s[1]);
            time = new int[n+1];
            indegree = new int[n+1];
            answer = new int[n+1];

            s = br.readLine().split(" ");
            for(int r = 1; r <= n; r++ ) {
                time[r] = Integer.parseInt(s[r-1]);
            }

            for(int p = 0; p <= n; p++) {
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < k; j++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                list.get(a).add(b);
                indegree[b]++;
            }

            find();

            int node = Integer.parseInt(br.readLine());
            sb.append(time[node]+answer[node]).append("\n");
        }

        System.out.println(sb);
   } 
}
