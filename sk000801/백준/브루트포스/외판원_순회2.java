import java.util.*;

public class 외판원_순회2 {
    static int n;
    static int[][] price;
    static boolean[] visited;
    static int min;
    static int first;
    
    public static void dfs(int depth, int hap, int num) {
        if(depth == n && first == num) {
            min = Math.min(min, hap);
            return;
        }

        if(!visited[num]) {
            visited[num] = true;
            depth++;
            for(int i = 0; i < n; i++) {
                if(price[num][i] != 0) dfs(depth,hap+price[num][i],i);
            }
            visited[num] = false;
        }
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        price = new int[n][n];
        visited = new boolean[n];
        min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                price[i][j] = in.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            first = i;
            dfs(0, 0, i);
        }
        
        System.out.println(min);
    }
}

//num이 인덱스를 도는 n까지의 도달 장소(?)들
//first는 마지막에 들어오는 곳이 순회되어 처음 num과 같아야 하므로 따로 변수를 지정해줌
//(그래서 마지막 depth일 때 num과 first가 같은지 비교해줌)
//main문에서는 시작 지점을 달리 설정하고, dfs 함수에서는 시작 지점에서 이동 지점을 설정해줌