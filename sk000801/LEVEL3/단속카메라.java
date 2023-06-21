package sk000801.LEVEL3;
import java.util.*;
//2분컷~!
public class 단속카메라{
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        
        int answer = 0;
        int start = -30001;
        for(int i = 0; i < routes.length; i++) {
            if(start < routes[i][0]) {
                start = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
