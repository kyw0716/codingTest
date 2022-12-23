import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] all = new int[9];
        int[] fake = new int[2];
        int hap  = 0;

        for(int i = 0; i < 9; i++) {
            all[i] = in.nextInt();
            hap += all[i];
        }

        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(hap-all[i]-all[j] == 100) {
                    fake[0] = i;
                    fake[1] = j;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i != fake[0] && i != fake[1]) System.out.println(all[i]);
        }
    }
}