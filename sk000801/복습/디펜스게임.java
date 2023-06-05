package sk000801.복습;
import java.util.*;

//11분인디
//우선순위 큐 보고 알아챔.. ㅠㅠ
// 4 2 4 5 3 3 1 로 치면 (k = 3) 아래처럼 5라운드 까지 가능
// n = 3 (큐에 4)
// n = 1 (큐에 4 2)
// n = -3 + 4 (큐에 4 2)
// n = 1+4-5 (큐에 5 2)
// n = 0-3+5 (큐에 3 2)
// n = 2-3 (k 이제 없음, 불가능)
public class 디펜스게임 {
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k >= enemy.length) return enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.add(enemy[i]);

            if(n<0) {
                if(k>0 && !pq.isEmpty()) {
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
    public static void main(String[] args) {
        int n1 = 7; int k1 = 3; int[] enemy1 = {4,2,4,5,3,3,1};
        int n2 = 2; int k2 = 4; int[] enemy2 = {3,3,3,3};
        System.out.println(solution(n2, k2, enemy2));
    }
}
