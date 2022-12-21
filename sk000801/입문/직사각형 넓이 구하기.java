import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(int i = 0; i < dots.length; i++) {
            if(!x.contains(dots[i][0])) x.add(dots[i][0]);
            if(!y.contains(dots[i][1])) y.add(dots[i][1]);
        }
        return Math.abs(x.get(0)-x.get(1))*Math.abs(y.get(0)-y.get(1));
    }
}