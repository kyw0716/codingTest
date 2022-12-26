import java.util.*;

public class 날짜_계산 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int E = in.nextInt();
        int S = in.nextInt();
        int M = in.nextInt();

        int y = 1;
        
        for(;;) {
            if((y-E)%15==0 && (y-S)%28==0 && (y-M)%19==0) {
               break;
            }
            y++;
        }

        System.out.println(y);
    }
}
