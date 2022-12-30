import java.util.*;

public class 좋은_구간 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] set = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++) {
            set[i] = in.nextInt();
        }
        Arrays.sort(set);

        int num = in.nextInt();

        for(int i = 0; i < n; i++) {
            if(num == set[i]) {
                System.out.println(0);
                return;
            }
        }

        if(num<set[0]) {
            if(num==1) count += set[0]-2;
            else count += set[0]-2+(num-1)*(set[0]-num-1);
        } else {
            int[] nums = new int[n+1];
            for(int i = 0; i <= n; i++) {
                if(i==n) nums[i] = num;
                else nums[i] = set[i];
            }
            Arrays.sort(nums);

            int index = 0;
            for(int i = 0; i <= n; i++) {
                if(nums[i] == num) {
                    index = i;
                    break;
                }
            } 

            for(int i = nums[index-1]+1; i < nums[index]; i++) {
                count += nums[index+1]-nums[index];
            }
            count += nums[index+1]-1-num;
        }

        System.out.println(count);
    }
}
