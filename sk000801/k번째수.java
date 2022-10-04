import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cut);
            answer[i] = cut[commands[i][2]-1];
        }
        return answer;
    }
}