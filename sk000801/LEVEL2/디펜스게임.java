package sk000801.LEVEL2;

//병사n명, enemy[i]만큼 n명에서 계속 소모, 남은 병사 보다 enemy[i]가 더 많으면 종료
//무적권은 k번 사용할 수 있고 이를 사용하면 소모없이 한 라운드의 공격을 막음
//30분동안 고민하고 다시 힌트 보고 푸는데 3분...
import java.util.*;
class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = enemy.length;
        if(k >= enemy.length) return answer;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);
            
            if(n<0) {
                if(k > 0 && !pq.isEmpty()) {
                    n += pq.poll();
                    k--;
                } else {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
