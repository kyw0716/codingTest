package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//위상정렬 -> 선후관계가 정의된 그래프 구조에서 정렬을 위해 사용하는
//그대신 비순환 관계여야 함
public class 줄세우기 {
    static int n, m;
    static List<List<Integer>> rank = new ArrayList<>();
    static int[] indegree;
    static StringBuffer sb = new StringBuffer("");
    public static void bfs() {
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> res = new LinkedList<Integer>();

        for(int i = 1; i <= n; i++) {
            //진입차수가 0이라는 것은 우선순위가 높은? 노드인것
            if(indegree[i] == 0) q.offer(i);
        }

        //큐에서 값을 꺼내 해당 노드의 indgree값을 감소시키고
        //0이된다면 큐에 넣기
        while(!q.isEmpty()) {
            int n = q.poll();
            res.offer(n);

            for(Integer i : rank.get(n)) {
                indegree[i]--;

                if(indegree[i] == 0) q.offer(i);
            }
        }

        while(!res.isEmpty()) {
            sb.append(res.poll()+" ");
        }
    }
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        indegree = new int[n+1];
        //해당 노드를 가리키는 간선 개수를 담는 배열

        for(int i = 0; i <= n; i++) {
            rank.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            s = br.readLine().split(" ");
            rank.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            indegree[Integer.parseInt(s[1])]++;
        }

        bfs();

        System.out.println(sb);
    }  
}
