package sk000801.복습;

public class 삼각달팽이2 {
    //삼각달팽이 움직이는거 크게 3가지
    //그냥 아래로 내려가거나
    //가장 아래까지 도달하면 오른쪽으로
    //오른쪽 끝까지 도달하면 위로 이동
    //9분인데 얘는 다시 봐야 할듯..
    public static int[] solution(int n) {
        int x = -1; int y = 0;
        int val = 1;
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i%3==0) x++; //아래
                else if(i%3==1) y++; //오른
                else {x--;y--;} //위
                arr[x][y] = val++;
            }
        }

        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] != 0) answer[idx++] = arr[i][j];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int n = 4;
        int[] ans = solution(n);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
