package sk000801.백준.DP;
import java.io.*;

public class 연속합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n+1];

        String[] s = br.readLine().split(" ");
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i-1]);
        }

        if(n==1) {System.out.println(nums[1]); return;}

        int max = nums[1];
        for(int i = 2; i <= n; i++) {
            if(nums[i-1]>0 && nums[i]+nums[i-1]>0) {
                nums[i] += nums[i-1];
            }
            if(nums[i] > max) max = nums[i];
            //hap[i] = Math.max(Math.max(nums[i], nums[i-1]+nums[i]), hap[i-1]);
        }

        System.out.println(max);
    }
}

//함정이 그득한 문제!!!!
//연속합 중간에 음수가 껴 있지만 그 다음이 모두 양수라면 충분히 최댓값이 될 수 있음
