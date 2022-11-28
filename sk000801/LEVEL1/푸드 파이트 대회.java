class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++) {
            if(food[i] > 1) {
                for(int j = 1; j <= food[i]/2; j++) {
                    answer += i;
                }
            }
        }
        String reverse = "";
        for(int i = 0; i < answer.length(); i++) {
            reverse += answer.charAt(answer.length()-1-i);
        }
        String realAnswer = answer+ "0" + reverse;
        return realAnswer;
    }
}