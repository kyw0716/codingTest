package sk000801.LEVEL2;

import java.util.*;
class Solution {
    List<String> sosu;
    public boolean check(String num) {
        long n = Long.parseLong(num);
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 2; i <= (int)Math.sqrt(n); i++) {
            if(n%i == 0) return false;
        }
        return true;
    }
    
    public int solution(int n, int k) {
        String num = Integer.toString(n, k);
        String[] nums = num.split("0");
        List<String> list = new ArrayList<>();
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(!nums[i].equals("")) list.add(nums[i]); 
        }
        
        for(int i = 0; i < list.size(); i++) {
            if(check(list.get(i))) ans++;
        }

        return ans;
    }
}
