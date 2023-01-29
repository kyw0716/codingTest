package sk000801.백준.그래프;
import java.util.*;

public class 트리 {
    static int n;
    static int[] parent;
    static boolean[] visited;

    //자신의 부모노드를 저장할 배열, 제거될 때 자식노드까지 제거
    public static void remove(int i) {
        parent[i] = -2;
        visited[i] = true;

        for(int j = 0; j < n; j++) {
            if(parent[j] == i) remove(j);
            //지울 노드가 주어진 노드의 부모라면, 자식도 지워줘야함
        }
    }

    public static int count() {
        int res = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;
            if(isLeaf(i)) res++;
        }
        return res;
    }

    //부모 배열을 돌며 자신이 부모인 자식 노드가 있다면 leaf X
    public static boolean isLeaf(int i) {
        visited[i] = true;

        boolean leaf = true;
        for(int j = 0; j < n; j++) {
            if(parent[j] == i) {
                leaf = false;
                break;
            }
        }
        return leaf;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        parent = new int[n];
        visited = new boolean[n];
        String[] s = in.nextLine().split(" ");
        for(int i = 0; i < n; i++) {
            parent[i] = Integer.parseInt(s[i]); 
            //각 노드의 부모가 주어짐
        }
        int erase = Integer.parseInt(in.nextLine());
        remove(erase);

        System.out.println(count());
    }
}
