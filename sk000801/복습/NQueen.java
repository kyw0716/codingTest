package sk000801.복습;

//옛날에도 지금에도 8분이긴 한데..
//같은 행과 열, 대각선(잡힐 수 있음..)에 체스가 존재할 경우 false
public class NQueen {
    static int answer = 0;
    public static boolean check(int depth, int n, int[] queen) {
        for(int i = 0; i < depth; i++) {
            if(queen[i] == queen[depth]) return false;

            if(Math.abs(i-depth) == Math.abs(queen[i]-queen[depth])) return false;
        }
        return true;
    }
    public static void dfs(int depth, int n, int[] queen) {
        if(depth == n) {
            answer++;
            return;
        }

        for(int i = 0; i < n; i++) {
            queen[depth] = i;
           
            if(check(depth, n, queen)) dfs(depth+1, n, queen);
        }
    }
    public static int solution(int n) {
        int[] queen = new int[n];

        dfs(0, n, queen);

        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solution(n));
    }   
}
