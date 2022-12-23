import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
        int count = 1;
        int i = 666;

        while(count < N) {
            i++;
            String ii = String.valueOf(i);
            if(ii.contains("666")) {
                count++;
            }
        }

        System.out.println(i);
    }
}
