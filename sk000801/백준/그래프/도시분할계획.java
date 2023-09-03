package sk000801.백준.그래프;
import java.util.*;

//prim 알고리즘
//MST 사용?
//cost가 가장 큰 값을 저장 = max
//간선 선택 = dist에 추가
//MST 구했다면 dist에서 가장 큰 value값(max)을 뺀 뒤 반환
public class 도시분할계획 {
    static int n, m;
    static List<List<Road>> road = new ArrayList<>();
    static boolean[] visited;

    public static class Road implements Comparable<Road> {
        int dest, value;
        Road(int dest, int value) {
            this.dest = dest;
            this.value = value;
        }
        @Override
        public int compareTo(Road a) {
            return this.value-a.value;
        }
    }

    public static int prim() {
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.add(new Road(1, 0));
        int dist = 0;
        int max = 0;

        while(!pq.isEmpty()) {
            Road cur = pq.poll();

            if(visited[cur.dest]) continue;

            visited[cur.dest] = true;
            max = Math.max(max, cur.value);
            dist += cur.value;

            for(int i = 0; i < road.get(cur.dest).size(); i++) {
                Road next = road.get(cur.dest).get(i);
                if(!visited[next.dest]) {
                    pq.add(new Road(next.dest, next.value));
                }
            }
        }

        return dist-max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++) {
            road.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            road.get(a).add(new Road(b, c));
            road.get(b).add(new Road(a, c));
        }

        int ans = prim();
        System.out.println(ans);
    }
}
