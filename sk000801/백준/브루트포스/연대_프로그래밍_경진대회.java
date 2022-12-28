import java.util.*;

public class 연대_프로그래밍_경진대회 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int i = 1;
        int answer = 0;

        for(;;) {
            if(1+i+i*i == k) {
                answer = i;
                break;
            }
            i++;
        }

        System.out.println(answer);
    }
}
