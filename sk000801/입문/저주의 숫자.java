class Solution {
    public int solution(int n) {
        int answer = 1;
        int count = 0;
        while(count < n) {
            if(answer%3 != 0 && !String.valueOf(answer).contains("3")) {
                count++;
            }
            answer++;
        }
        return answer-1;
    }
}