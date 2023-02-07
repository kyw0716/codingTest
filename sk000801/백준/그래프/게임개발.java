package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1516
//위상정렬 => 이전의 줄 세우기 문제랑 비슷
//but 이 친구는 위 노드의 값도 계산해주어야 하므로 조금 더 복잡 ㅠㅠ
//while문을 거치면 상위 노드부터 큐를 거쳐가는데 이때 값을 미리 더해줌
public class 게임개발 {
    static int n;
    static int[] indegree;
    static int[] ans;
    static int[] time;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();

            for(Integer i : list.get(node)) {
                indegree[i]--;

                time[i] = Math.max(time[i], time[node]+ans[node]);

                if(indegree[i]==0) q.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        n = Integer.parseInt(br.readLine());
        indegree = new int[n+1];
        ans = new int[n+1]; //해당 노드 건축 시간
        time = new int[n+1]; //그 위의 노드(?) 건축 시간

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ans[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int a = Integer.parseInt(st.nextToken());
                if(a == -1) break;
                list.get(a).add(i);
                indegree[i]++;
            }
        }

        bfs();

        for(int i = 1; i <= n; i++) {
            System.out.println(time[i]+ans[i]);
        }
    }
}
