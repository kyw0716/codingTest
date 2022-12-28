import java.util.*;

public class 완전_제곱수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count = 0;
        int n = in.nextInt();

        for(int b = 1; b <= 500; b++) {
            for(int a = b; a <= 500; a++) {
                if(a*a == b*b+n) count++;
            }
        }

        System.out.println(count);
    }   
}
