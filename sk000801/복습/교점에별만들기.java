package sk000801.복습;
import java.util.*;

//26분
//진짜 모조리 long으로 바꿔벌임..
//setCharAt은 유념하기!!
public class 교점에별만들기 {
    public static String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long maxX = Long.MIN_VALUE; long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE; long minY = Long.MAX_VALUE;
        for(int i = 0; i < line.length-1; i++) {
            for(int j = i+1; j < line.length; j++) {
                long[] line1 =  new long[]{line[i][0], line[i][1], line[i][2]};
                long[] line2 = new long[]{line[j][0], line[j][1], line[j][2]};
                long bunmo = (line1[0]*line2[1]-line1[1]*line2[0]);
                if(bunmo == 0) continue;
                double x = (line1[1]*line2[2]-line1[2]*line2[1])/(double)bunmo;
                double y = (line1[2]*line2[0]-line1[0]*line2[2])/(double)bunmo;
                if((long)x-x == 0.0 && (long)y-y == 0.0) {
                        list.add(new long[]{(long)x, (long)y}); 
                        maxX = Math.max(maxX, (long)x);
                        maxY = Math.max(maxY, (long)y);
                        minX = Math.min(minX, (long)x);
                        minY = Math.min(minY, (long)y);
                }
            }
        }

        Set<long[]> set = new HashSet<>(list);
        list = new ArrayList<>(set);

        String[] ans = new String[(int)(maxY-minY)+1];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = ".".repeat((int)(maxX-minX)+1);
        }

        for(long[] p : list) {
            StringBuilder sb = new StringBuilder(ans[(int)(p[1]-minY)]);
            sb.setCharAt((int)(p[0]-minX), '*');
            ans[(int)(p[1]-minY)] = sb.toString();
        }

        List<String> answer = Arrays.asList(ans);
        Collections.reverse(answer);
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[][] line1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] res = solution(line1);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
