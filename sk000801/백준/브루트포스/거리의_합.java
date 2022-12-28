import java.util.*;

public class 거리의_합 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        long hap = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                hap += Math.abs(num[i]-num[j]);
            }
        }

        System.out.println(hap);
    }
}

