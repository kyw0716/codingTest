class Solution {
    public boolean solution(int x) {
        int result = 0;
        int original_x = x;
        int length = (int) (Math.log10(x)+1);
        for(int n=0; n<length; n++) {
            result += x%10;
            x/=10;
        }
        boolean answer = false;
        if(original_x%result == 0) answer = true;
        return answer;
    }
}