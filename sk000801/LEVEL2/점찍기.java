package sk000801.LEVEL2;

//casting이 중요했던 문제
//31분
//x제곱+y제곱=반지름제곱 의 식을 생각하면 두 개의 범위로 나누지 않아도 풀 수 있음
//그러나 d가 백만이기 때문에 long형으로 변환해서 값을 구해줘야 overflow가 나지 않음
//1번의 테케에서 x = 0이면 y는 4이기 때문에 4/2 = 2이므로 x가 0일때 y는 0, 2, 4 즉 3개가 가능하므로
//(작은값)y/k+1(0포함) 으로 개수를 세어주는 것이 맞음
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i += k) {
            double y = Math.sqrt((long)d*d-(long)i*i);
            answer += Math.floor(y/k)+1;
        }
        return answer;
    }
}
