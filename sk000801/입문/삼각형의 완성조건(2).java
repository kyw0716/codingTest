// 가장 긴 변  i < sides[0]+sides[1]
// 긴 변 x i+sides[0] > sides[1];
class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        for(int i = Math.max(sides[0], sides[1])+1; i < sides[0]+sides[1]; i++) {answer++;}
        for(int j = Math.abs(sides[0]-sides[1])+1; j <= Math.max(sides[0],sides[1]); j++) {answer++;} 
        return answer;
    }
}