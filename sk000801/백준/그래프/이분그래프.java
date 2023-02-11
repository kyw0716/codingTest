package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//내가 간과한 두가지 경우
//1. 주어진 노드들 중 모든 노드를 연결하지 않은 경우
//2. 주어진 노드가 하나로 다 연결되어있지 않은 경우
public class 이분그래프 {
    static int v, e;
    static int[] visited;
    static boolean[] exist;
    static List<List<Integer>> list;
    public static void bfs2() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= v; i++) {
            if(visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int now = q.poll();

                for(Integer num : list.get(now)) {
                    if(visited[num] == 0) q.add(num);
                    if(visited[num] == visited[now]) {
                        System.out.println("NO");
                        return;
                    }
                    if(visited[now] == 1 && visited[num] == 0) {
                        visited[num] = 2;
                    }
                    else if(visited[now] ==2 && visited[num] == 0) {
                        visited[num] = 1;
                    }
                }
            }
        }

        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            String[] s = br.readLine().split(" ");
            v = Integer.parseInt(s[0]);
            visited = new int[v+1];
            exist = new boolean[v+1];
            list = new ArrayList<>();
            e = Integer.parseInt(s[1]);

            for(int j = 0; j <= v; j++) {
                list.add(new ArrayList<>());
            }

            for(int r = 0; r < e; r++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                list.get(a).add(b);
                list.get(b).add(a);
            }

            bfs2();
        }
    }
}
