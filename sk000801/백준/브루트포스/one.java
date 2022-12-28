import java.util.*;

public class one {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int n = in.nextInt();
            int num = 0;
            for(int i = 1;; i++) {
            num = (num*10+1)%n;
            if(num==0) {
                System.out.println(i);
                break;
            }
        }
        }
    }
}
