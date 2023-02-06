package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1717
//유니온파인드로 풀기 -> 부모를 찾아야 모든 값들을 탐색할 수 있음
public class 집합의표현 {
    static int[] parent;
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public static void union(int x, int y) {
        if(x==y) return;
        x = find(x); //x의 부모 노드
        y = find(y); //y의 부모 노드

        //이미 같은 집합이라면 굳이 갱신하지 않아도 됨
        if(x<y) parent[y] = x;
        else if(x>y) parent[x] = y;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer("");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(num == 0) union(a,b);
            else {
                if(a==b) {
                    sb.append("YES\n");
                    continue;
                }
                if(find(a) == find(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
