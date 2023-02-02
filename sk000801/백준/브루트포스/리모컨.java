package sk000801.백준.브루트포스;
import java.util.*;

//숫자버튼'만' 부서짐
//버튼이 아예 안고장났을수도
//채널 0~무한대
//채널 범위는 50만이나 그 이후로 넘어갔을 때 -로 돌아올 수 있음
//정말 말그대로 완전 탐색의 진수...... 흑흑
//
public class 리모컨 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        boolean[] arr = new boolean[10];

        for(int i = 0; i < m; i++) {
            arr[in.nextInt()] = true;
        }

        int res = Math.abs(100-n); //+,-로 움직였을 때를 초기값으로
        for(int i = 0; i <= 1_000_000; i++) {
            String s = String.valueOf(i);
            boolean check = false;
            for(int j = 0; j < s.length(); j++) {
                if(arr[s.charAt(j)-'0']) { //고장난 버튼이라면
                    //-'0'은 정수형으로 바꿔줌
                    //(int)로 바꾸면 아스키코드 값으로 바꾼다 주의!!
                    check = true;
                    break;
                }
            }
            if(!check) {
                int ans = s.length()+Math.abs(i-n);
                res = Math.min(ans, res);
            }
        }
        System.out.println(res);
    }
}
