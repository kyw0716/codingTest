import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        for(int i = 2992; i <= 9999; i++) {
            int count = 0;
            int count1 = 0;
            int count2 = 0;
            String i1 = String.valueOf(i);
            String i2 = Integer.toString(i, 12);
            String i3 = Integer.toHexString(i);
            for(int p = 0; p < i1.length(); p++) {
                count += Character.getNumericValue(i1.charAt(p));
            } for(int q = 0; q < i2.length(); q++) {
                count1 += Character.getNumericValue(i2.charAt(q));
            } for(int r = 0; r < i3.length(); r++) {
                count2 += Character.getNumericValue(i3.charAt(r));
            }
            if(count == count1 && count1 == count2) {
                System.out.println(i);
            }
        }
    }
}

// you are buung siin