package sk000801.백준.그리디;
import java.util.*;

//문자열 뒤에 A를 추가
//문자열 뒤집고 B를 추가
public class A와B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String t = in.nextLine();

        while(s.length() < t.length()) {
            int i = t.length()-1;
            if(t.charAt(i) == 'A') {
                t = t.substring(0, i);
            }
            else {
                t = t.substring(0, i);
                StringBuilder sbs = new StringBuilder(t);
                t = sbs.reverse().toString();
            }
        }
        
        if(s.equals(t)) System.out.println(1);
        else System.out.println(0);
    }
}
