import java.util.*;

public class 기숙사_바닥 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int R = in.nextInt();
        int B = in.nextInt();

        int gaesu = R+B;

        int L = 0;
        int W = 0;

        for(int i = 3; i <= gaesu; i++) {
            if(gaesu % i == 0) {
                L = Math.max(i, gaesu/i);
                W = Math.min(i, gaesu/i);
                if((2*(L+W)-4) == R) {
                    break;
                }
            }
        }

        System.out.println(L+" "+W);
    }
}
