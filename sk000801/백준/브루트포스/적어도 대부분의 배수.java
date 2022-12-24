import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] five = new int[5];
        int number = 0;

        for(int i = 0; i < 5; i++) {
            five[i] = in.nextInt();
        }

        Arrays.sort(five);

        for(int i = 4; i <= 950600; i++) {
            int count = 0;
            for(int j = 0; j < 5; j++) {
                if(i%five[j] == 0) count++;
            }
            if(count>=3) {
                number = i;
                break;
            }
        }

        System.out.println(number);
    }
}

//그걸 잊지 말자 나올수 있는 세 수의 최소곱과 최대곱으로 for문을 돌리자!