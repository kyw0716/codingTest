package sk000801.LEVEL2;
//그니까 이 좌표가 x^2+y^2이 r1^2 이상이어야 하고 r2^2 이하여야 함
//근데 이 좌표의 경우의 수를 어케 for문 한번 만에 찾아내지,,?
//그래서 생각함 x, y좌표 모두 양수인 경우 1~r2값 까지 두 원의 y값을 구해 그 사이에 있는 정수값을 더함
//31분
//y1값은 ceil인 이유가 3.1212일때 4부터 값이 가능하고
//y2값은 floor인 이유가 3.1212일때 3까지 값이 가능하므로
class 두원사이의정수쌍 {
    public long solution(int r1, int r2) {
        long answer = 0;
        for(long x = 1; x <= r2; x++) {
            double val1 = Math.sqrt((double)r1*r1-x*x);
            double val2 = Math.sqrt((double)r2*r2-x*x);
            long y1 = (int) Math.ceil(val1);
            long y2 = (int) Math.floor(val2);
            answer += 4*(y2-y1+1);
        }
        return answer;
    }
}
