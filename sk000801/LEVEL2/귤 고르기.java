import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
class Solution {
    public int solution(int k, int[] tangerine) {
        int k1 = k;
        int answer = 0;
        List<Integer> tangerines = new ArrayList<>();
        for(int i = 0; i < tangerine.length; i++) {
            tangerines.add(tangerine[i]);
        }
        Set<Integer> sizes = new HashSet<>(tangerines);
        List<Integer> size = new ArrayList<>(sizes);   
        Integer[] common = new Integer[size.size()];
        for(int i = 0; i < size.size(); i++) {
            common[i] = Collections.frequency(tangerines, size.get(i));
        }
        Arrays.sort(common, Collections.reverseOrder());
        for(int i = 0; i < common.length; i++) {
            if(common[i] >= k) {
                answer = 1;
                break;
            } else if (k1 > 0) {
                answer += 1;
                k1 -= common[i];    
            }
        } 
        return answer;
    }
}