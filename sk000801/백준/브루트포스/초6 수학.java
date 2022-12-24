import java.util.Scanner;

public class Main {
    public static void print(int a, int b) {
        int choiso = 1;
        for(int i = 1; i <= Math.min(a, b); i++) {
            if(a%i==0 && b%i==0) choiso = i;
        }
        System.out.println(a*b/choiso + " " + choiso);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt();

        for(int i = 0; i < size; i++) {
            print(in.nextInt(), in.nextInt());
        }
    }
}