import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int M = in.nextInt();
        int N = in.nextInt();

        int count = 0;
        int choiso = 0;
        int hap = 0;

        for(int i = M; i <= N; i++) {
            double num = (double) Math.sqrt(i);
            if(num-Math.floor(num) == 0.0) {
                count++;
                if(count==1) choiso = i;
                hap += i;
            }   
        }

        if(count == 0) System.out.println("-1");
        else {
            System.out.println(String.valueOf(hap));
            System.out.println(String.valueOf(choiso));
        }
    }
}