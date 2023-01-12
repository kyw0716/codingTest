package sk000801.백준.그리디;
import java.util.*;

public class _30 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuffer sb = new StringBuffer("");

        //3의 배수는 모든 자릿수의 합이 3의 배수, 30의 배수는 이에 마지막 자리가 0
        String s = in.nextLine();
        String[] ss = s.split("");
        int[] nums = new int[ss.length];
        int hap = 0;
       
        for(int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(ss[i]);
            hap += nums[i];
        }
        Arrays.sort(nums);

       if(s.contains("0") && hap % 3 == 0) {
            for(int i = nums.length-1; i >= 0; i--) {
                sb.append(String.valueOf(nums[i]));
            }
       } else {
            System.out.println(-1);
            return;
       }

       System.out.println(sb);
        
    }
}
