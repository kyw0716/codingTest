import java.util.*;

public class 부분수열의합 {

    static int[] num;
    static boolean[] visited;
    static int n;
    static int s;
    static int count = 0;

    public static void dfs(int one, int index) {
        if(index == n) {
            visited[one] = true;
            return;
        } 

        dfs(one+num[index], index+1);
        dfs(one, index+1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        num = new int[n];
        visited = new boolean[20*100000];

        for(int i = 0; i < n; i++) {
           num[i] = in.nextInt();
        }
        
        dfs(0, 0);

        for(int i = 1;; i++) {
            if(!visited[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
