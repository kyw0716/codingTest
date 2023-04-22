package sk000801.복습;

//25분인데
//원래 풀이랑 유사하게 풀음 이 문제가 제대로 내가 이해는 했을까?
public class 행렬테두리회전하기 {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] ori = new int[rows][columns];
        for(int i = 0; i < ori.length; i++) {
            for(int j = 0; j < ori[0].length; j++) {
                ori[i][j] = rows*i+j+1;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0]-1; int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1; int y2 = queries[i][3]-1;

            int temp = ori[x1][y1];
            int min = temp;
            for(int x = x1+1; x <= x2; x++) { //위로
                min = Math.min(min, ori[x][y1]);
                ori[x-1][y1] = ori[x][y1];
            }
            for(int y = y1+1; y <= y2; y++) { //왼쪽
                min = Math.min(min, ori[x2][y]);
                ori[x2][y-1] = ori[x2][y];
            }
            for(int x = x2-1; x >= x1; x--) { //아래로
                min = Math.min(min, ori[x][y2]);
                ori[x+1][y2] = ori[x][y2];
            }
            for(int y = y2-1; y >= y1; y--) { //오른쪽으로
                min = Math.min(min, ori[x1][y]);
                ori[x1][y+1] = ori[x1][y];
            }
            ori[x1][y1+1] = temp;
            answer[i] = min;
        }
        return answer;
    }
    public static void main(String[] args) {
        int rows1 = 6; int columns1 = 6; int[][] queries1 = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        int rows2 = 3; int columns2 = 3; int[][] queries2 = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        int[] ans = solution(rows2, columns2, queries2);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }    
}
