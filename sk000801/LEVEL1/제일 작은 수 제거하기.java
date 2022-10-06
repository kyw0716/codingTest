import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        int count = 0;
        if(arr.length <= 1) return answer;
        else {
            int min = Arrays.stream(arr).min().getAsInt();
            answer = new int[arr.length-1];
            for(int i=0; i<arr.length; i++) {
                if(arr[i] == min) continue;
                else {answer[count] = arr[i];count++;}
            }
        }
        return answer;
    }
}