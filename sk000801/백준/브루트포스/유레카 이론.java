import java.util.Scanner;
import java.util.*;

public class Main {
    public static int check(int num, List<Integer> yureka) {
        for(int i = 0; i < yureka.size(); i++) {
            for(int j = 0; j < yureka.size(); j++) {
                for(int p = 0; p < yureka.size(); p++) {
                    if(yureka.get(i)+yureka.get(j)+yureka.get(p) == num) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int size = in.nextInt();
        int[] nums = new int[size];
        
        List<Integer> yureka = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        for(int i = 1; i <= 45; i++) {
            yureka.add(i*(i+1)/2);
        }

        for(int i = 0; i < nums.length; i++) {
            System.out.println(String.valueOf(check((nums[i]), yureka)));
        }

    }
}