package sk000801.LEVEL2;

//11분, 분할정복!
//처음에 주어진 전체 정사각형 값이 0, 혹은 1로 동일할때의 경우를 생각 안하고 무작정 반으로 분할하고 시작해 답이 제대로 안나옴 ㅠㅠ
class Solution {
    int[][] copy;
    int answer0 = 0;
    int answer1 = 0;
    public void divide(int x, int y, int s) {
        int val = copy[x][y];
        int count = 0;
        for(int i = x; i < x+s; i++) {
            for(int j = y; j < y+s; j++) {
                if(val == copy[i][j]) count++;
            }
        }
        if(count == s*s) {
            if(val == 0) answer0++;
            else answer1++;
            return;
        }
        
        divide(x, y, s/2);
        divide(x+s/2, y, s/2);
        divide(x, y+s/2, s/2);
        divide(x+s/2, y+s/2, s/2);
    }
    public int[] solution(int[][] arr) {
        copy = arr;
        int[] answer = new int[2]; //0개수, 1개수가 담긴
        divide(0, 0, arr[0].length);
        answer[0] = answer0; answer[1] = answer1;
        return answer;
    }
}