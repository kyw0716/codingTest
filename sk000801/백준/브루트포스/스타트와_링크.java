import java.util.Scanner;

public class 스타트와_링크 {
    static int N;
    static int[][] pyo;
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;

    public static void dfs(int depth, int index) {
        if(depth == N/2) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < N-1; i++) {
                for(int j = i+1; j < N; j++) {
                    if(visit[i] == true && visit[j] == true) {
                        a += pyo[i][j];
                        a += pyo[j][i];
                    } if(visit[i] == false && visit[j] == false) {
                        b += pyo[i][j];
                        b += pyo[j][i];
                    }
                }
            }
            int value = Math.abs(a-b);
            min = Math.min(min, value);
            return;
        } else {
            for(int i = index; i < N; i++) {
                if(visit[i]) continue;
                visit[i] = true;
                dfs(depth+1, i+1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        pyo = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                pyo[i][j] = in.nextInt();
            }
        }

        dfs(0, 0);

        System.out.println(min);        
    }
}

//크기가 N인 boolean 배열을 선언하여 방문 했는지 여부를 체크한뒤
//이부분이 아마도 DFS로 푸는게 좋은듯
//true/false로 팀을 나눠 pyo안의 값을 계산해주면 된다

//dfs는 항상 그러더라 재귀라서 main문 안에서는 초기값으로 선언만 해주고
//함수 안에서 for문을 돌리면서 방문 기록을 남기고
//모든 경우의 수를 초기값에서 증가시킨 재귀로 센다(?)
