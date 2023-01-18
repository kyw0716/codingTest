package sk000801.백준.그래프;

import java.io.*;
import java.util.*;

public class 최단경로 {
    static int v;
    static int e;
    static int k;
    static int U, V, K;
    static int[] dist;  //거리 배열
    static ArrayList[] ad;    //인접배열
    //기준점이 정해져 있으므로 다익스트라 알고리즘(O(nlogn))을 사용하는 것이 좋음
    //처음 생각했던 플로이드 워샬(o(n^2))은 시간 초과 발생할듯함...
    //(애초에 주어진 정점과 간선의 개수가 겁나 많음)
    //https://subbak2.com/m/55

    public static class Edge implements Comparable<Edge> {
        int id, cost;

        public Edge(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost-e.cost;
        }
    }
    //이건 완전 처음 들어보는 것...

    public static void dikstra(int start) {
        //출발지를 우선순위 큐에 넣고 시작
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        dist[start] = 0;
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) { //특정 목적지에 도착했을 떄 break
            Edge e = pq.poll();

            //더 큰 가중치에 도착한 경우 넘어감
            if(e.cost > dist[e.id]) continue;

            //현재 위치에 연결된 간선 탐색
            int length = ad[e.id].size();
            for(int i = 0; i < length; i++) {
                Edge next = (Edge) ad[e.id].get(i);

                //비용이 더 작을때만 갱신하고 PQ에 넣기
                if(dist[next.id] > e.cost + next.cost) {
                    dist[next.id] = e.cost + next.cost;
                    pq.add(new Edge(next.id, dist[next.id]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        k = Integer.parseInt(br.readLine());

        dist = new int[v+1];
        for(int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        ad = new ArrayList[v+1];
        for(int i = 1; i <= v; i++) {
            ad[i] = new ArrayList<Edge>();
        }

        for(int i = 1; i <= e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ad[U].add(new Edge(V, K));
        }

        dikstra(k);

        for(int i = 1; i <= v; i++) {
            if(dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}
