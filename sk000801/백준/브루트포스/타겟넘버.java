class Solution {
    static int count = 0;
    static int answer;
    public void dfs(int[] numbers, int num, int index) {
        if(index == numbers.length) {
            if(num==answer) count++;
            return;
        }
        dfs(numbers, num-numbers[index], index+1);
        dfs(numbers, num+numbers[index], index+1);
    }
    public int solution(int[] numbers, int target) {
        answer = target;
        dfs(numbers, 0, 0);
        return count;
    }
}