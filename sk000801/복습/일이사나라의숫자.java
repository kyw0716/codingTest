package sk000801.복습;

public class 일이사나라의숫자 {
    //규칙파악 15분컷!!
    public static String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        while(n>0) {
            int res = n%3;
            if(res == 0) {
                n -= 1; //자릿수가 바뀌는 부분이라 1을 빼줘야됨
                sb.append("4");
            } else if(res == 1) {
                sb.append("1");
            } else {
                sb.append("2");
            }
            n /= 3;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}
