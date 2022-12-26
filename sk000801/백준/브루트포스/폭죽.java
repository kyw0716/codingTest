import java.util.*;

public class 폭죽 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int C = in.nextInt();
        
        boolean[] time = new boolean[C];

        for(int i = 0; i < N; i++) {
            int a = in.nextInt();
            for(int j = 1; j <= C; j++) {              
                if(j%a==0) time[j-1] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < time.length; i++) {
            if(time[i]) count++;
        }

        System.out.println(count);
    }
}
