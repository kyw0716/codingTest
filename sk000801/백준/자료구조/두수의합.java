import java.io.*;
import java.util.Arrays;

public class 두수의합 {
    //투 포인터 알고리즘을 사용해야만 쉽게 풀리는 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        int[] num = new int[n];

        for(int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(num);

        int x = Integer.parseInt(br.readLine());
        int count = 0;

        int i = 0;
        int j = n-1;

        while(i<j) {
            int ii =  num[i]+num[j];
            if(ii == x) count++;
            
            if(ii < x) {
                i++;
            }
            else j--;
        }

        System.out.println(count);
    }
}
