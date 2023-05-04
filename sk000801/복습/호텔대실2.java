package sk000801.복습;
import java.util.*;

//이건 당최 어떻게 풀어야 할 지 감도 안잡힘ㅋ
//어떻게 푸는지 다시 힌트를 얻어 푼거라 시간 잰게 의미 없을듯
public class 호텔대실2 {
    public static int solution(String[][] book_time) {
        int[][] time = new int[book_time.length*2][2];

        for(int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            time[2*i][0] = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            time[2*i][1] = 0;
            String[] fin = book_time[i][1].split(":");
            time[2*i+1][0] = Integer.parseInt(fin[0])*60+Integer.parseInt(fin[1])+10;
            time[2*i+1][1] = 1;
        }

        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return b[1]-a[1];
                return a[0]-b[0];
            }
        });

        int ans = 0;
        int cur = 0;
        for(int i = 0; i < time.length; i++) {
            if(time[i][1] == 0) cur++;
            else cur--;
            ans = Math.max(ans, cur);
        }

        return ans;
    }
    public static void main(String[] args) {
        String[][] book_time1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time1));
    }
}
