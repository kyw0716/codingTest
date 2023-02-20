package sk000801.백준.분할정복;
import java.util.*;

//m이 단어의 첫번째인지 판별
public class Moo수열 {
    static int n;
    static String ans = "";
    public static void moo(int n) {
        int len = 3;
        int idx = 0;

        if(n==1) ans = "m"; //그냥 첫번째 글자면
        else if(n<=3) ans = "o"; //moo일 때
        else {
            while(len < n) { //아직 문자열의 길이가 주어진 n보다 작다면
                len = len*2+idx+4; //4는 두번째 수열 m~~oo를 더해주기 위함 
                idx++; 
            }

            int front_back = (len-idx-3)/2; 
            //3을 빼주는 이유는 while문에서 idx가 1씩 증가해서 
            //중간+4가 실제 idx 영역보다 커짐!
            //front_back은 m부터 o가 k+3개 있을 때 그 직전 인덱스

            if(len-front_back+1 <= n) { //여기가 해석이 안됨
                moo(n-len+front_back);
            } 
            else if(n == front_back+1) ans = "m"; //가운데에 moo~ 부분의 첫부분
            else ans = "o"; //그 이외의 부분은 계속 o만 존재함
        } 

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();

        moo(n);

        System.out.println(ans);
    }
}
