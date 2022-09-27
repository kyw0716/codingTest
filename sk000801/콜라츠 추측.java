class Solution {
    public int solution(int num) {
        int count = 0;
        while(num != 1) {
            if(count>500) {
                count = -1;
                break;
            }    
            if(num % 2 == 0) {
                num /= 2;
            }
            else if(num % 2 == 1) {
                num = 3*num+1;
            }
            count ++;
        }
        return count;
    }
}