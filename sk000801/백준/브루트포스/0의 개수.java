import java.util.Scanner;

public class 0의_개수 {
    public static int count(int a, int b) {
        int count = 0;
        for(int i = a; i <= b; i++) {
            String s = String.valueOf(i);
            count += s.length()-s.replaceAll("0", "").length();
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int c = in.nextInt();

        for(int j = 0; j < c; j++) {
            int a = count(in.nextInt(), in.nextInt());
            System.out.println(a);
        }
    }
}