import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        int count=0, index=0;
        int[] answer = {-1};
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%divisor==0) count++;
        }
        if(count>=1) answer = new int[count];
        for(int i=0; i<arr.length;i++) {
            if(count==0)break;
            if(arr[i]%divisor==0) {answer[index] = arr[i];
            index++;}
        }
        Arrays.sort(answer);
        return answer;
    }
}