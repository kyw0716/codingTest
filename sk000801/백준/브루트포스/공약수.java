import java.util.Scanner;

public class Main {
    public static int calculate(int a, int b) {
        int choiso = 1;
        for(int i = 1; i <= Math.min(a,b); i++) {
            if(a%i==0 && b%i==0) {
                choiso = i;
            }
        }
        return choiso;
    }

    public static void print(int a) {
        for(int i = 1; i <= a; i++) {
            if(a%i==0) System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int gaesu = in.nextInt();
        int choiso = 1;

        if(gaesu==2) choiso = calculate(in.nextInt(), in.nextInt());
        else {
            choiso = calculate(in.nextInt(), in.nextInt());
            choiso = calculate(choiso, in.nextInt());
        }

        print(choiso);
    }
}