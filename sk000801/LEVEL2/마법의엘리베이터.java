package sk000801.LEVEL2;

//참고+18분
//if문을 통해 올림이 더 짧을 때의 경우를 고려해줬어야 함,,
public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int move = storey%10;
            storey /= 10;   
            if(move > 5 || (move == 5 && storey%10 >= 5)) {
                //만약 내림보다 올림이 움직이는 거리가 더 짧다면
                move = 10 - move;
                storey++;
            }
            //56 -> 60 -> 100 -> 0 (4+4+1)
            answer += move;
        }
        return answer;
    }
}

//첫번째 풀이
//그저 내림만 고려한 풀이
// int[] val = new int[10];
// for(int i = 9; i >= 1; i--) {
//     val[i] = storey / (int) Math.pow(10, i);
//     storey %= Math.pow(10, i);
// }
// val[0] = storey;
// int ans = 0;
// for(int i = 0; i <= 9; i++) {
//     ans += val[i];
// }
// return ans;
