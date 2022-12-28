import java.util.*;

public class Four_Squares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;

        double nn = (double) Math.sqrt(n);
        if(nn-Math.floor(nn) == 0) {System.out.println(1); return;}

        List<Integer> nums = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            nums.add(i*i);
        }
        
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                if(nums.get(i)+nums.get(j) == n) {
                    System.out.println(2);
                    return;
                }
            }
        }

        for(int i = 0; i < nums.size(); i++) {
            for(int j = 0; j < nums.size(); j++) {
                for(int r = 0; r < nums.size(); r++) {
                    if(nums.get(i)+nums.get(j)+nums.get(r) == n) {
                        System.out.println(3);
                        return;
                    }
                }
            }
        }

        System.out.println(4);
    }
}
