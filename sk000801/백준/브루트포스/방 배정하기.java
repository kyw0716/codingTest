import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] size = new int[3];
        int answer = 0;

        for(int i = 0; i < size.length; i++) {
            size[i] = in.nextInt();
        }
        Arrays.sort(size);

        int num = in.nextInt(); 

        for(int i = num/size[0]; i >= 0; i--) {
            for(int j = num/size[1]; j >= 0; j--) {
                for(int p = num/size[2]; p >= 0; p--) {
                    if(num == (p*size[2]+j*size[1]+i*size[0])) {
                        answer = 1;
                    }   
                }
            }
        }
        System.out.println(answer);
    }
}