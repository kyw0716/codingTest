import java.util.*;

class Solution6 {
    public int solution(int[][] sizes) {
        for(int i=0; i<sizes.length; i++) {
            if(sizes[i][0]<sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }
        int garo = sizes[0][0];
        int sero = sizes[0][1];
        for(int j=1; j<sizes.length; j++) {
            if(garo<sizes[j][0]) garo = sizes[j][0];
            if(sero<sizes[j][1]) sero = sizes[j][1];
        }
        int answer = garo*sero;
        return answer;
    }
}