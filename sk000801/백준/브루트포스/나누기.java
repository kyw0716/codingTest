import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int F = in.nextInt();

        String[] ss = String.valueOf(N).split("");

        for(int i = 0; i <= 99; i++) {
            if(i<10) {
                ss[ss.length-2] = "0";
                ss[ss.length-1] = String.valueOf(i);
            } else {
                String[] s = String.valueOf(i).split("");
                ss[ss.length-2] = s[0];
                ss[ss.length-1] = s[1];
            }
            int num = Integer.parseInt(String.join("", ss));
            if(num%F == 0) {
                System.out.println(ss[ss.length-2]+ss[ss.length-1]);
                break;
            }
        }
    }
}
