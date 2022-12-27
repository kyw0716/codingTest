import java.util.*;

public class 수학적_호기심 {
    public static int count(int n, int m) {
        int count = 0;
        double answer = 0.0;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                answer = (double) ((Math.pow(i,2)+Math.pow(j,2)+m) / (i*j));
                if(answer-(int)answer == 0 && i<j) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for(int i = 0; i < t; i++) {
            System.out.println(count(in.nextInt(), in.nextInt()));
        }
    }
}
