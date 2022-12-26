import java.util.*;

public class 거꾸로_구구단 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int max = 0;

        for(int i = 1; i <= K; i++) {
            StringBuffer num = new StringBuffer(String.valueOf(N*i));
            String rev = num.reverse().toString();
            max = Math.max(Integer.parseInt(rev), max);
        }

        System.out.println(max);
    }
}
