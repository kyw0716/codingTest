package sk000801.LEVEL2;

import java.util.*;
class 교점에별만들기 {
    //아놔 long타입 변환 ㅠㅠㅠㅠ
    //69분 ㅠㅠㅠ
    public String[] solution(int[][] line) {
        //int pointCase = (line.length*(line.length-1))/2;
        List<long[]> point = new ArrayList<>();
        for(int i = 0; i < line.length-1; i++) {
            for(int j = i+1; j < line.length; j++) {
                long[] line1 = new long[]{line[i][0], line[i][1], line[i][2]};
                long[] line2 = new long[]{line[j][0], line[j][1], line[j][2]};
                if(line1[0]*line2[1]-line1[1]*line2[0] != 0) {
                    double x = (line1[1]*line2[2]-line1[2]*line2[1]) / (double) (line1[0]*line2[1]-line1[1]*line2[0]);
                    double y = (line1[2]*line2[0]-line1[0]*line2[2]) /  (double) (line1[0]*line2[1]-line1[1]*line2[0]);
                    if(x - (long)x == 0.0 && y -(long)y == 0.0 && !point.contains(new long[]{(long)x, (long)y})) point.add(new long[]{(long)x, (long)y});
                }
            }
        }
        Set<long[]> set = new HashSet<>(point);
        point = new ArrayList<>(set);
        
        long minX = Long.MAX_VALUE; 
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for(long[] p : point) {
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            minY = Math.min(minY, p[1]);
            maxY = Math.max(maxY, p[1]);
            //System.out.println(p[0]+" "+p[1]);
        }
        
        String[] answer = new String[(int)(maxY-minY)+1];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ".".repeat((int)(maxX-minX)+1);
        }
        for(long[] p : point) {
            StringBuilder sb = new StringBuilder(answer[(int)(p[1]-minY)]);
            sb.setCharAt((int)(p[0]-minX), '*');
            answer[(int)(p[1]-minY)] = sb.toString();
        }
        List<String> ans = Arrays.asList(answer);
        Collections.reverse(ans);
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
