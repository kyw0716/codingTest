package sk000801.백준.그리디;
import java.util.*;

//나의 처음 계획은 홀수개인 알파벳만 가운데에 붙이고 앞뒤로 짝수개 알파벳을 붙일라 했는데
//이렇게 되면 홀수개에서 오류가 발생함(A3B2->BAAAB but 답 ABABA)
//이걸 개수가 존재하는 모든 값을 반씩 더해준뒤
//홀수는 한번더 더해주면 됨!

public class 팰린드롬만들기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.nextLine().split("");
        int[] gaesu = new int[26];
        StringBuffer answer = new StringBuffer("");

        for(int i = 0; i < s.length; i++) {
            gaesu[(int)s[i].charAt(0)-65]++;
        }

        int hol = 0;
        for(int i = 0; i < 26; i++) {
            if(gaesu[i]%2==1) hol++;
        }
        if(hol>1) {System.out.println("I'm Sorry Hansoo"); return;}

        String holsu = "";
        for(int i = 0; i < 26; i++) {
            if(gaesu[i]==0) continue;
            for(int j = 0; j < gaesu[i]/2; j++) {
                    answer.append(Character.toString(i+65));
            }
        }            
        for(int i = 0; i < 26; i++) {
            if(gaesu[i]%2==1) {
                holsu += Character.toString(i+65);
            } 
        }

        String ans = answer.toString()+holsu+answer.reverse().toString();
        System.out.println(ans);
    }
}
