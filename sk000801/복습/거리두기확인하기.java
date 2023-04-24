package sk000801.복습;
import java.util.*;

// P: 앉아있는 자리 | O: 빈 테이블 | X: 파티션
//20분컷 !!  꺄 !! 그때는 못풀었던 거 같운데
//dist가 2가되는 조건을 잘 생각해보면 돼
//그것보다 작으면 바로 옆칸이니까 무조건 안되구
public class 거리두기확인하기 {
    public static boolean check(String[][] place, List<int[]> seat) {
        for(int i = 0; i < seat.size(); i++) {
            for(int j = 0; j < seat.size(); j++) {
                if(i == j) continue;
                int[] jap1 = seat.get(i);
                int[] jap2 = seat.get(j);
                int dist = Math.abs(jap1[0]-jap2[0])+Math.abs(jap1[1]-jap2[1]);
                if(dist<=1) return false;
                if(dist == 2) {
                    if(jap1[0] == jap2[0]) {
                        if(!place[jap1[0]][(jap1[1]+jap2[1])/2].equals("X")) return false;
                    }
                    else if(jap1[1] == jap2[1]) {
                        if(!place[(jap1[0]+jap2[0])/2][jap1[1]].equals("X")) return false;
                    }
                    else if(!(place[jap1[0]][jap2[1]].equals("X") && place[jap2[0]][jap1[1]].equals("X"))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static int[] solution(String[][] places) {
        int[] ans = new int[places.length];
        for(int i = 0; i < places.length; i++) {
            String[][] place = new String[5][5];
            List<int[]> seat = new ArrayList<>();
            for(int j = 0; j < 5; j++) {
                place[j] = places[i][j].split("");
            }

            for(int x = 0; x < 5; x++) {
                for(int y = 0; y < 5; y++) {
                    if(place[x][y].equals("P")) seat.add(new int[]{x, y});
                }
            }

            if(check(place, seat)) ans[i] = 1;
            else ans[i] = 0;
        }
        return ans;
    }
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        int[] ans = solution(places);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
