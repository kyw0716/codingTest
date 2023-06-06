package sk000801.복습;

//14분....? 사실 풀이 방식이 맞아서 그 이상은 안보고 싶음
public class 두원사이의정수쌍 {
    //중심이 원점이고 반지름 길이가 r1, r2인 두 원
    //r1의 ceil, r2의 floor
    //아니 원래 풀이에서는 Math.sqrt와 Math.ceil을 두번 나눠 풀이했는데
    //똑같이 풀었는데 왜 두번 나눈건 정답이고 이건 틀렷삼 ㅠㅠ
    public static long solution(int r1, int r2) {
        long answer = 0;
        for(int i = 1; i <= r2; i++) {
            long a = (long) Math.ceil(Math.sqrt(r1*r1-i*i));
            long b = (long) Math.floor(Math.sqrt(r2*r2-i*i));
            answer += 4*(b-a+1);
        } 
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, 3));
    }
}
