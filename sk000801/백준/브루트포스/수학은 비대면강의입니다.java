import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] up = new int[3];
        int[] down = new int[3];

        int x = 0;
        int y = 0;

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 3; j++) {
                if(i==0) up[j] = in.nextInt();
                else down[j] = in.nextInt();
            }
        }

        for(int i = -999; i <= 999; i++) {
            for(int j = -999; j <= 999; j++) {
                if(up[0]*i+up[1]*j == up[2] && down[0]*i+down[1]*j == down[2]) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y);
    }
}

//알고리즘에 충실할 것!!!
//이 식을 찾기 보다는 for문으로 값을 다 찾아봐야함!!