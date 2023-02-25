package sk000801.LEVEL3;

import java.util.*;
class Solution {
    public long solution(long n, int[] times) {
        long answer = 0;
        long left = 1;
        Arrays.sort(times);
        long right = times[times.length-1]*n;
        long mid = 0;
        
        while(left <= right) {
            mid = (left+right)/2;
            long tmp = 0;
            for(Integer time : times) {
                if(tmp >= n) break;
                tmp += (mid/time);
            }
            
            if(tmp >= n) {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return answer;
    }
}
