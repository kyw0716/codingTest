package sk000801.LEVEL2;

//사실 백준에서 풀었던 문제
//8분
//인덱스->열, 인덱스 값->행 그래서 1차원 배열로 
class NQueen {
    int[] queen;
    int n1;
    int answer = 0;
    public boolean isRight(int depth) {
        for(int i = 0; i < depth; i++) {
            if(queen[i] == queen[depth]) return false;
            
            if(Math.abs(depth-i) == Math.abs(queen[depth]-queen[i])) return false; //대각선
        }
        return true;
    }
    public void position(int depth) {
        if(depth == n1) {
            answer++;
            return;
        }
        
        for(int i = 0; i < n1; i++) {
            queen[depth] = i;
            
            if(isRight(depth)) {
                position(depth+1);
            }
        }
    }
    public int solution(int n) {
        n1 = n;
        queen = new int[n];
         
        position(0);
        return answer;
    }
}
