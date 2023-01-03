package sk000801.백준.DP;
import java.util.*;

public class 돌게임 {
    static int answer;
    public static void dp(int num, int count) {
        if(num==0) {answer = count;return;}
        if(num>=1) dp(num-1, count+1);
        if(num>=3) dp(num-3, count+1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        
       //dp(n, 0);

        System.out.println(n%2==0? "CY" : "SK");
    }
}
