import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] array2 = new int[array.length];
        for(int i = 0; i < array2.length; i++) {
            array2[i] = array[i];
        }
        int[] answer = new int[2];
        Arrays.sort(array2);
        answer[0] = array2[array.length-1];
        for(int i = 0; i < array.length; i++) {
            if(array[i] == answer[0]) {
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}

//자바 indexof
//자바 Math.max