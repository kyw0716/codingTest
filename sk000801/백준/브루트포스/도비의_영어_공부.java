import java.util.*;

public class 도비의_영어_공부 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        for(;;) {
            String a = in.nextLine();
            if(!a.equals("#")) {
                String aa = Character.toString(a.charAt(0));
                String b = a.substring(2, a.length());
                String ori = b;
                b = b.replaceAll(aa.toLowerCase(), "");
                b = b.replaceAll(aa.toUpperCase(), "");
                System.out.println(aa + " " + String.valueOf(ori.length()-b.length()));
            }
            else break;
        }
    }
}
