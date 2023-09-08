package sk000801.백준.그래프;
import java.util.*;

public class 숫자고르기 {
    static int[] num;
    static List<Integer> list = new ArrayList<>();
    static boolean[] visited;
    public static void dfs(int start, int dest) {
        if(!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], dest);
            visited[num[start]] = false;
        }

        if(num[start] == dest) list.add(dest);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        num = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        Collections.sort(list);

        System.out.println(list.size());
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
