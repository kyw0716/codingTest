class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] split = my_string.split("");
        String answer = "";
        for(int i = 0; i < split.length; i++) {
            if (i == num1) {
                answer += split[num2];
            }
            else if (i == num2) {
                answer += split[num1];
            }
            else answer += split[i];
        }
        return answer;
    }
}