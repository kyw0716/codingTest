package sk000801.백준.bfs연습;
import java.util.*;

public class 케빈베이컨6단계법칙 {
    //얘도 BFS 라기 보다는
    //플로이드 와샬 알고리즘에 더 가까운듯
    //옛날 '친구' 문제와 비슷한..?
    static int[][] friends;
    static boolean[] visited;
    static int[] bacon;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        friends = new int[n+1][n+1];
        bacon = new int[n+1];
        int m = in.nextInt();
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i==j) friends[i][j] = 0; //같은 노드를 지날 수 없으므로
                else friends[i][j] = 99999; //그 이외에는 큰 값을 집어넣음
            }
        }

        for(int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            friends[a][b] = friends[b][a] = 1; //한번에 갈 수 있으므로 최소값 1을 넣어줌
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int p = 1; p <= n; p++) {
                    friends[j][p] = Math.min(friends[j][p], friends[j][i]+friends[i][p]);
                }
            }
        }

        int min = 999999;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                bacon[i] += friends[i][j];
            }
            //System.out.println(bacon[i]);
            min = Math.min(bacon[i], min);
        }

        for(int i = 1; i <= n; i++) {
            if(min == bacon[i]) {
                System.out.println(i);
                return;
            }
        }
    }
}
