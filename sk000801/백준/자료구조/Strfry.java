import java.util.*;
public class Strfry {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        int n = Integer.parseInt(in.nextLine());

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split(" ");

            char[] char1 = s[0].toCharArray();
            Arrays.sort(char1);
            String s1 = new String(char1);

            char[] char2 = s[1].toCharArray();
            Arrays.sort(char2);
            String s2 = new String(char2);

            if(s1.equals(s2)) sb.append("Possible");
            else sb.append("Impossible");
            sb.append("\n");
        }

        System.out.println(sb);
    }   
}
