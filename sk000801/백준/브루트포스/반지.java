import java.util.*;
public class 반지 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String find = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        int count = 0;

        for(int i = 0; i < n; i++) {
            String s = in.nextLine();
            String ss = s+s;

            if(s.contains(find) || ss.contains(find)) count++;
        }

        System.out.println(count);
    }
}
