import java.util.*;
class Solution {
    public int solution(int[] array) {
        List<Integer> number = new ArrayList<>();
        for(int i = 0; i < array.length; i++) {
            if(!number.contains(array[i])) {
                number.add(array[i]);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++) {
            if (!map.keySet().contains(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i])+1);
            }
        }

        int[] max = new int[map.size()];
        for(int i = 0; i < map.size(); i++) {
            max[i] = map.get(number.get(i));
        }
        
        Arrays.sort(max);
        if (max.length>1 && max[max.length-1] == max[max.length-2]) {
            return -1;
        }
        
        int answer = 0;
        for(Integer key : map.keySet()) {
            if(map.get(key) == max[max.length-1]) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}