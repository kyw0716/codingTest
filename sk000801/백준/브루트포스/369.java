import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int count = 0;

        for(int i = 1; i <= N; i++) {
            String ii = String.valueOf(i);
            for(int j = 0; j < ii.length(); j++) {
                char c = ii.charAt(j);
                if(c == '3' || c == '6' || c == '9') {
                    count++;
                }
            }
            
        }

        System.out.println(count);
    }
}