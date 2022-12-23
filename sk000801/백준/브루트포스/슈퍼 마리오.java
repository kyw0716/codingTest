import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hap = in.nextInt();

        for(int i = 1; i < 10; i++) {
            int a = in.nextInt();
            if(Math.abs(hap-100) >= Math.abs(hap+a-100)) {
                hap +=a;
            } else {
                break;
            }
        }

        System.out.println(hap);
    }
}