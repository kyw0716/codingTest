package sk000801.백준.백트래킹;
import java.io.*;
import java.util.*;

//수 6개를 골라야 함 주어진 숫자들 중
public class 로또 {
    static int n;
    static int[] num;
    static int[] all;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer("");

    public static boolean check(int[] num) {
        for(int i = 0; i < 5; i++) {
            if(num[i] >= num[i+1]) return false;
        }
        return true;
    }

    public static void dfs(int depth) {
        if(depth == 6) {
            if(check(num)) {
                for(int i = 0; i < 6; i++) {
                    sb.append(num[i]+" ");
                }
                sb.append("\n");
            }
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                num[depth] = all[i];
                visited[i] = true;
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0) break;
            num = new int[6];
            all = new int[n];
            visited = new boolean[n];

            for(int i = 0; i < n; i++) {
                all[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
