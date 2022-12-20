import java.util.*;
class Solution {
    public int[] solution(int[] emergency) {
        int[] sort = new int[emergency.length];
        int[] answer = new int[emergency.length];
        for(int i = 0; i < emergency.length; i++) {
            sort[i] = emergency[i];
        }
        Arrays.sort(sort);
        for(int i = 0; i < emergency.length; i++) {
            for(int j = 0; j < emergency.length; j++) {
                if(sort[i] == emergency[j]) answer[i] = emergency.length-j;
            }
        }
        return answer;
    }
}

// Arrays.stream(e).map(i -> Arrays.stream(e).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i) + 1).toArray();