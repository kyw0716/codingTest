import java.util.*;

public class 숫자_야구 {
    public static int strike(int num1, int num2) {
        int count = 0;
        String a = String.valueOf(num1);
        String b = String.valueOf(num2);
        for(int i = 0; i < 3; i++) {
            if(a.charAt(i)==b.charAt(i)) count++;
        }
        return count;
    }
    public static int ball(int num1, int num2) {
        int count = 0;
        String[] a = String.valueOf(num1).split("");
        String b = String.valueOf(num2);
        for(int i = 0; i < 3; i++) {
            if(b.contains(a[i])) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] num = new int[n];
        int[] strike = new int[n];
        int[] ball = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            strike[i] = in.nextInt();
            ball[i] = in.nextInt();
        }

        for(int i = 123; i <= 987; i++) {
            if(i%10 == 0 || (i/10)%10 == 0) continue;
            if(i/100 == i%10 || (i/10)%10 == i/100 || (i/10)%10 == i%10) continue;
            int count1 = 0;
            for(int j = 0; j < n; j++) {
                if(strike(i, num[j]) == strike[j]
                && ball(i, num[j])-strike[j] == ball[j]) count1++;
            }
            if(count1 == n) count++;
        }
        
        System.out.println(count);
    }
}
