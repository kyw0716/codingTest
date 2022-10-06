import java.util.*;

public class Solution4 {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++) {
            if(arr[i] != arr[i+1]) {
                list.add(arr[i]);
            }
            if(i == arr.length-2) list.add(arr[arr.length-1]);
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}