import java.util.*;

public class 방번호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String num = String.valueOf(in.nextInt());
        int[] repeat = new int[10];

        for(int i = 0; i < num.length(); i++) {
            repeat[Character.getNumericValue(num.charAt(i))]++;
        }

        double max1 = (double) (repeat[6]+repeat[9])/2;
        int max = (int) Math.round(max1);
        for(int i = 0; i <= 9; i++) {
            if(i != 6 && i != 9) max = Math.max(repeat[i], max);
        }

        System.out.println(max);
    }
}
