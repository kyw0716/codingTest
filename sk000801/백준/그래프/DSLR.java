package sk000801.백준.그래프;
import java.util.*;

//40분
//https://www.acmicpc.net/problem/9019
//큐에 string이 담긴 class를 넣는게 굉장히 무거운가봄
public class DSLR {
    static String[] command = {"D", "S", "L", "R"};

    public static int register(int num, int idx) {
        int val = num;
        switch(idx) {
            case 0:
                val = D(num);
                break;
            case 1:
                val = S(num);
                break;
            case 2:
                val = L(num);
                break;
            case 3:
                val = R(num);
                break;
        }
        return val;
    }
    public static int D(int num) {
        return num*2 > 9999 ? (num*2) % 10000 : num*2;
    }
    public static int S(int num) {
        return num == 0 ? 9999 : num-1;
    }
    public static int L(int num) {
        return (num%1000)*10+num/1000;
    }
    public static int R(int num) {
        return (num%10)*1000+num/10;
    }
    public static String bfs(int start, int fin) {
        boolean[] visited = new boolean[10000];
        String[] ans = new String[10000];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        Arrays.fill(ans, "");

        while(!q.isEmpty() && !visited[fin]) {
            int cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int next = register(cur, i);
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    ans[next] = ans[cur]+command[i];
                }
            }
        }

        return ans[fin];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("");

        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            int before = in.nextInt();
            int after = in.nextInt();
            sb.append(bfs(before, after)).append("\n");
        }

        System.out.println(sb);
    }
}