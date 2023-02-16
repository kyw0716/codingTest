package sk000801.백준.복습;
import java.io.*;
import java.util.*;

public class 이분그래프 {
    static int v, e;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= v; i++) {
            if(visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while(!q.isEmpty()) {
                int num = q.poll();
    
                for(Integer next : list.get(num)) {
                    if(visited[next] == 0) q.add(next);
                    if(visited[num] == visited[next]) {
                        System.out.println("NO");
                        return;
                    }
                    if(visited[num] != 0 && visited[next] == 0) {
                        visited[next] = -visited[num];
                    }
                }
            }
        }
        System.out.println("Yes");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            String[] s = br.readLine().split(" ");
            v = Integer.parseInt(s[0]);
            e = Integer.parseInt(s[1]);

            for(int r = 0; r <= v; r++) {
                list.add(new ArrayList<>());
            } 

            for(int j = 0; j < e; j++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                
                list.get(a).add(b);
                list.get(b).add(a);
            }

            visited = new int[v+1];
            bfs();
        }
    }
}
