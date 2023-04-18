package sk000801.LEVEL2;
import java.util.*;

//45분
//힌트 참조 -> 시간을 아예 다 더한뒤 입실, 퇴실을 구분
//시간 순으로 정렬 / 같다면 퇴실 먼저 오도록
//변수를 설정해 입실인 경우에 ++, 퇴실인 경우에 --하면서 가지는 최댓값을 정답으로 설정
class Solution {
    public int solution(String[][] book_time) {
        int[][] s = new int[book_time.length*2][2];
        for(int i = 0; i < book_time.length; i++) {
            String[] start = book_time[i][0].split(":");
            String[] fin = book_time[i][1].split(":");
            int value = Integer.parseInt(start[0])*60+Integer.parseInt(start[1]);
            s[i*2][0] = value; s[i*2][1] = 0;
            value = Integer.parseInt(fin[0])*60+Integer.parseInt(fin[1])+10;
            s[i*2+1][0] = value; s[i*2+1][1] = 1;
        }
        
        Arrays.sort(s, new Comparator<int[]>() {
            @Override
            public int compare(int[] s1, int[] s2) {
                if(s1[0] == s2[0]) {
                    if(s1[1]<s2[1]) return 1;
                    else return -1;
                }
                return s1[0]-s2[0];
            }
        });

        int ans = 0;
        int cur = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i][1] == 0) cur++;
            else cur--;
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
