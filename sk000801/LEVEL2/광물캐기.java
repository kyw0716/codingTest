package sk000801.LEVEL2;
//순서대로 다이아, 철, 돌 곡괭이 수
//곡괭이를 하나 선택할 때마다 광물 5개를 연속으로 캠

//필요한 곡괭이의 수를 정하고
//곡괭이의 수가 크기인 배열을 만들어 순열을 통해 모든 경우의 수를 탐색
//만들어진 배열을 통해 피로도를 구하고 원래의 정답값과 비교해 최솟값을 answer에 넣어줌

//바보같이 picks의 개수를 5개씩 채울 때마다 하나씩 줄여야 하는데
//하나의 mineral을 캘 때마다 없애니까 피로도가 계산이 안됐던 것...
//이 문제만 생각했어도 바로 푸는건데,,,,

//거의 87분...
import java.util.*;
class 광물캐기 {
    int[] diap = {1,1,1};
    int[] ironp = {5,1,1};
    int[] stonep = {25,5,1};
    int answer = Integer.MAX_VALUE;
    public int cal(int[] ans, String[] minerals, int[] picks) {
        int total = 0;
        int[] pick = new int[3];
        for(int i = 0; i < pick.length; i++) {
            pick[i] = picks[i];
            total += pick[i];
        }
        int res = 0;
        for(int j = 0; j < minerals.length; j++) {
            if(j+1 > total*5) return res; 
            switch(ans[j/5]) {
                case 0:
                    if(minerals[j].equals("diamond")) res += diap[0];
                    if(minerals[j].equals("iron")) res += diap[1];
                    if(minerals[j].equals("stone")) res += diap[2];
                    if(j%5==0) {
                        pick[0]--;
                        if(pick[0]<0) return 100000;
                    } 
                    break;
                case 1:
                    if(minerals[j].equals("diamond")) res += ironp[0];
                    if(minerals[j].equals("iron")) res += ironp[1];
                    if(minerals[j].equals("stone")) res += ironp[2];
                    if(j%5==0) {
                        pick[1]--;
                        if(pick[1]<0) return 100000;
                    } 
                    break;
                case 2:
                    if(minerals[j].equals("diamond")) res += stonep[0];
                    if(minerals[j].equals("iron")) res += stonep[1];
                    if(minerals[j].equals("stone")) res += stonep[2];
                    if(j%5==0) {
                        pick[2]--;
                        if(pick[2]<0) return 100000;
                    }
                    break;
                }
        }
        return res;
    }
    public void countCase(int pickNum, int depth, int[] ans, String[] minerals, int[] picks) {
        if(depth == pickNum) {
            int val = cal(ans, minerals, picks);
            answer = Math.min(answer, val);
            return;
        }
        
        for(int j = 0; j < 3; j++) {
            ans[depth] = j;
            countCase(pickNum, depth+1, ans, minerals, picks);
        }
    }
    public int solution(int[] picks, String[] minerals) {
        int pickNum = minerals.length % 5 == 0 ? minerals.length/5 : minerals.length/5+1;
        int[] ans = new int[pickNum];
        Arrays.fill(ans, -1);
        countCase(pickNum, 0, ans, minerals, picks);
        return answer;
    }
}
