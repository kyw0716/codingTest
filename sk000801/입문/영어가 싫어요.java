class Solution {
    public long solution(String numbers) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] nums = {"0","1","2","3","4","5","6","7","8","9"};
        String answer = numbers;
        for(int i = 0; i <= 9; i++) {
            answer = answer.replaceAll(num[i], nums[i]);
        }
        return Long.parseLong(answer);
    }
}