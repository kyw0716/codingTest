import java.util.*;

public class 개수세기 {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        
        int x = in.nextInt();
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(x == num[i]) count++;
        }

        System.out.println(count);
    }
}
