class Solution {
    public boolean sosu(int num){
        for (int i = 2; i <= Math.sqrt(num); i++)
        { if (num % i == 0) return false;
        }
                return true;
    }
    
    public int solution(int[] nums) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            if(i+2>=nums.length) break;
            for(int j=i+1; j<nums.length; j++) {
                for(int p=j+1; p<nums.length; p++) {
                    int hap_v = nums[i]+nums[j]+nums[p];
                    if(sosu(hap_v)) count++;
                }
            }
        } 
      
        return count;
    }
}