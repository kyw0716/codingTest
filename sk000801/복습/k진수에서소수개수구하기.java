package sk000801.복습;
import java.util.*;

//7분컷!
public class k진수에서소수개수구하기 {
    public static boolean check(long num) {
        if(num <= 1) return false;
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int answer = 0;
        int n = in.nextInt();
        int k = in.nextInt();

        String s = Integer.toString(n, k);
        String[] num = s.split("0");

        for(int i = 0; i < num.length; i++) {
            if(num[i].equals("") || num[i].equals("0")) continue;
            long numb = Long.parseLong(num[i]);
            if(check(numb)) answer++;
        }

        System.out.println(answer);
    }
}