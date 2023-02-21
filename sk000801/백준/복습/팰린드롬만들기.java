package sk000801.백준.복습;
import java.util.*;

//대문자 아스키코드 65
public class 팰린드롬만들기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] count = new int[26];
        String ans = "";

        String[] s = in.nextLine().split("");
        for(int i = 0; i < s.length; i++) {
            char c = s[i].charAt(0);
            count[(int)c-65]++;
        }
        
        int holsu = 0;
        for(int i = 0; i < 26; i++) {
            if(count[i]%2==1) holsu++;
        }
        if(holsu>=2) {
            System.out.println("I'm Sorry Hansoo");
            return;
        } 

        for(int i = 0; i < 26; i++) {
            for(int j = 0; j < count[i]/2; j++) {
                ans += String.valueOf((char)(i+65));
            }
        }
        StringBuffer sb = new StringBuffer(ans);
        sb = sb.reverse();
        for(int i = 0; i < 26; i++) {
            if(count[i]%2==1) {
                ans += String.valueOf((char)(i+65));
            }
        }
        ans += sb.toString();

        System.out.println(ans);
    }
}
