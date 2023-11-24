package sk000801.백준.이분탐색;
import java.util.*;

import java.util.*;

//n개의 강의, m개의 블루레이
public class 기타레슨 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[] num = new int[n];
        int min = 1;
        int max = 1;
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
            min = Math.max(num[i], min);
            max += num[i];
        }

        while(min <= max) {
            int mid = (min+max)/2;
            int sum = 0;
            int count = 1;

            for(int i = 0; i < n; i++) {
                sum += num[i];
                if(sum >mid) {
                    sum = num[i];
                    count++;
                }
            }

            if(count > m) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(min);
    }
}

