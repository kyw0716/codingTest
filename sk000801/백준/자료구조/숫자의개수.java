import java.util.*;

public class 숫자의개수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        String gop = String.valueOf(a*b*c);

        for(int i = 0; i <= 9; i++) {
            System.out.println(String.valueOf(gop.length()-gop.replaceAll(String.valueOf(i), "").length()));
        }

    }
}
