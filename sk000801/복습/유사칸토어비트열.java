package sk000801.복습;

//1
//11011
//11011 11011 0 11011 11011
//5로 나눴을 때 3번째 인덱스?? 다 0
//규칙을 알아버려서 4분컷됨
public class 유사칸토어비트열 {
    public static boolean check(long l) {
        if(l < 5 && l != 2) return true;
        if((l-2)%5 == 0) return false;

        return check(l/5);
    }
    public static int solution(int n, long l, long r) {
        int answer = 0;

        for(long i = l-1; i < r; i++) {
            if(check(i)) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 17));
    }
}
