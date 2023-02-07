package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//벨만 포드 알고리즘?? 이게 뭐람(음수일때도 최단거리 구할 수 있는)
//음수사이클 탐지
//https://www.acmicpc.net/problem/11657
 
public class 타임머신 {
 
    static int v;
    static int e;
    static List<Node>list;
    static long[] distance;

    public static class Node{
        int start;
        int end;
        int cost;
     
        public Node(int start,int end, int cost) {
            this.end = end;
            this.start=start;
            this.cost = cost;
        }
     
    }
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        list = new ArrayList<>();
        distance = new long[v + 1];
        for (int i = 1; i <= v; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        int a, b, c;
 
 
        for (int i = 0; i < e; i++) {
            String[] s1 = br.readLine().split(" ");
            a = Integer.parseInt(s1[0]);
            b = Integer.parseInt(s1[1]);
            c = Integer.parseInt(s1[2]);
            list.add(new Node(a,b, c));
        }
 
 
        StringBuilder sb = new StringBuilder();
 
        if(bellman()){
            for (int i = 2; i <= v; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(distance[i]).append("\n");
            }
        }
        else{
            sb.append(-1);
        }
 
        System.out.println(sb.toString());
    }
 
 
    public static boolean bellman() {
        distance[1] = 0;
        for(int i=1; i<=v; i++){
            for(Node a: list){
                if(distance[a.start]==Integer.MAX_VALUE){
                    continue;
                }
                if(distance[a.end]>distance[a.start]+a.cost){
                    distance[a.end]=distance[a.start]+a.cost;
                }
            }
        }
 
        for(int i=1; i<=v; i++){
            for(Node a: list){
                if(distance[a.start]==Integer.MAX_VALUE){
                    continue;
                }
                if(distance[a.end]>distance[a.start]+a.cost){
                    return false;
                }
            }
        }
        return true;
    }
}