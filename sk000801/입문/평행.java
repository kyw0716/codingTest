import java.util.*;
class Solution {
    public int solution(int[][] dots) {
        List<Double> g = new ArrayList<>(); 
        for (int i = 0; i < dots.length; i++) {
            for (int j = i+1; j < dots.length; j++) {
                double g1 = (double) (dots[i][1]-dots[j][1]) / (dots[i][0]-dots[j][0]);
                System.out.println(g1);
                if (g.contains(g1)) return 1;
                else g.add(g1);
            }
        }
        return 0;
    }
}