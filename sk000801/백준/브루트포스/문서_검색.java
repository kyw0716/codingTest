import java.util.*;
public class 문서_검색 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String pattern = in.nextLine();
        int count = 0;

        while(text.contains(pattern)) {
            text = text.replaceFirst(pattern, " ");
            count++;
        }

        System.out.println(count);
    }
}
