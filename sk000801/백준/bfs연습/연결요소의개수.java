package sk000801.백준.bfs연습;
import java.io.*;
import java.util.*;

public class 연결요소의개수 {
    static int n;
    static int[][] connect;
    static boolean[] visited;
    static Queue<Integer> q;

    public static void bfs(int idx) {
        q = new LinkedList<>();

        visited[idx] = true;
        q.add(idx);

        while(!q.isEmpty()) {
            int index = q.poll();

            for(int i = 1; i <= n; i++) {
                if(!visited[i] && connect[i][index] == 1) {
                    //궁금해서 connect[i][index]와 connect[index][i]를 돌렸는데
                    //둘다 된다. 사실 상관은 없을 것 같다. 1인지만 확인하면 되니까?
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        connect = new int[n+1][n+1];
        visited = new boolean[n+1];
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            connect[a][b] = connect[b][a] = 1;
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}

//main문에서 방문하지 않은 인덱스에 대해 answer값을 증가시켜주는 이유는
//bfs에서 탐색을 통해 노드가 연결되어 있다면 visited를 해줄 것이기 때문임!
//일단 모든 인덱스를 거치는 for문을 main문에서 돌린다
//bfs에서는 해당 인덱스에 대해 가장 먼저 q에서 넣고
//또 for문을 돌려 connect배열의 값이 1이며(간선이 존재) 방문하지 않은 노드에 대해
//visited 처리를 하고 q에 넣어준다. 
//(연결되어 있으니까 당연히 그 노드를 거쳐갈 것이기 때문)