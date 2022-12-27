import java.util.*;

public class 지각 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            int time = in.nextInt();
            int late = 0;
            for(int j = 1; j < 10000; j++) {
                if(j+Math.pow(j,2) > time) {late = j-1;break;}
            }
            System.out.println(late);
        }
    }
}
