import java.util.*;

public class 소수_팰린드롬 {
    public static boolean check(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num%i==0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int answer = 0;

        for(int i = n; i <= 1004000; i++) {
            if(i==1) continue;
            if(!check(i)) {
                String s = String.valueOf(i);
                if(s.length()%2==0) {
                    String s1 = s.substring(0, s.length()/2);
                    String s2 = s.substring(s.length()/2);
                    StringBuffer sb = new StringBuffer(s2);
                    if(s1.equals(sb.reverse().toString())) {
                        answer = i;
                        break;
                    }
                } else {
                    String s1 = s.substring(0, s.length()/2);
                    String s2 = s.substring(s.length()/2+1);
                    StringBuffer sb = new StringBuffer(s2);
                    if(s1.equals(sb.reverse().toString())) {
                        answer = i;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
