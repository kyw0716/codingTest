import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();

        for(int i = num; i >= 0; i--) {
            if(String.valueOf(i).replaceAll("[4 | 7]", "").equals("")) {
                System.out.println(i);
                break;
            }
        }
    }
}