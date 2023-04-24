package sk000801.복습;

//3분컷?
//하나의 값(x)에 대한 반복문을 돌리고 나머지는 x^2+y^2=반지름^2인 원의 방정식을 이용해
//남은 y의 값을 floor를 통해 가능한 모든 정수 값을 구하고 1을 더한다(0을 세줘야함)
//여기서 내가 놓친 건 for문을 돌릴 때 굳이 가능한 x의 값을 나눠 구하지 않고
//0부터 k씩 더해서 정답 y값만 찾아주면 되는거!!
public class 점찍기 {
    public static long solution(int k, int d) {
        long answer = 0;
        for(int i = 0; i <= d; i+=k) {
            double y = Math.sqrt((long)d*d-(long)i*i);
            answer += Math.floor(y/k)+1;
        }
        return answer;
    }
    public static void main(String[] args) {
        int k1 = 2; int d1 = 4;
        int k2 = 1; int d2 = 5;
        System.out.println(solution(k1, d1));
    }   
}
