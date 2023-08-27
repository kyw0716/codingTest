package sk000801.백준.그래프;
import java.util.*;

//39분
//혼자 헛발질..
public class 숨바꼭질2 {
    static int n, k;
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int[] value = new int[100_001];
        value[n] = 1;

        int min = Integer.MAX_VALUE;
        int count = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            //현재 방문 시간이 이미 최소 시간보다 크면 이후는 X
            if(min < value[cur]) break;

            for(int i = 0; i < 3; i++) {
                int next = cur;
                if(i == 0) next = cur*2;
                if(i==1) next = cur+1;
                if(i==2) next = cur-1;

                if(next < 0 || next > 100_000) continue;

                if(next == k) {
                    min = value[cur];
                    count++;
                }

                // 첫 방문 || 같은 시간에 방문
                if(value[next] == 0 || value[next] == value[cur]+1) {
                    q.add(next);
                    value[next] = value[cur]+1;
                }
            }
        }

        System.out.println(min);
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        n = Integer.parseInt(input.split(" ")[0]);
        k = Integer.parseInt(input.split(" ")[1]);

        if(n >= k) {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }

        bfs();
    }
}
