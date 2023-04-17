package sk000801.복습;

public class 삼각달팽이 {
    //15분인데 결국 풀이 힌트를 얻음(갈 수 있는 방향의 경우를 생각해보기!!)
    public static int[] solution(int n) {
        int[] ans = new int[n*(n+1)/2];
        int[][] val = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                //세갈래 방향으로 나뉜다는 것을 기억
                // 아래는 x값 증가 오른쪽은 y값 증가 대각선은 두 값 감소
                if(i%3==0) x++;
                else if(i%3==1) y++;
                else {x--; y--;}
                val[x][y] = num++;
            }
        }
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(val[i][j] != 0) ans[idx++] = val[i][j]; 
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] ans = solution(4);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
