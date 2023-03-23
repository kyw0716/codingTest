package sk000801.LEVEL2;

//39분~~ 
class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] arr = new int[n][n];
        int x = -1; int y = 0;
        int val = 1;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                //3가지의 패턴이 반복됨
                //n번 아래로
                //n-1번 오른쪽으로
                //n-2번 대각선으로..
                if(i%3==0) x++; //아래
                else if(i%3==1) y++; //오른쪽
                else {x--; y--;} //왼쪽위로
                arr[x][y] = val++;
            }
        }
        
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 0) continue;
                answer[index++] = arr[i][j];
            }
        }
        return answer;
    }
}
