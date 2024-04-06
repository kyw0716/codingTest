package sk000801.코드트리;

import java.util.*;

public class 정답루돌프의반란 {
    public static int l, n, q;
    public static int[][] map = new int[41][41];
    public static int[] knightpower = new int[31];
    public static int[] r = new int[31], c = new int[31], h = new int[31], w = new int[31], k = new int[31];
    public static int[] nr = new int[31], nc = new int[31];
    public static int[] damaged = new int[31];
    public static boolean[] is_moved = new boolean[31];

    public static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

    // 아예 이동하는 배열에 이동하는 값을 담아놓는다
    public static boolean canMove(int idx, int dir) {
        Queue<Integer> q = new LinkedList<>();

        // 초기화
        for(int i = 1; i <= n; i++) {
            damaged[i] = 0;
            is_moved[i] = false;
            nr[i] = r[i];
            nc[i] = c[i];
        }

        // 충돌해서 이동하는 knight만 q에 담음
        q.add(idx);
        is_moved[idx] = true;

        while(!q.isEmpty()) {
            int x = q.poll();

            nr[x] += dx[dir];
            nc[x] += dy[dir];

            // 해당 범위가 map을 벗어나면 아예 false
            if(nr[x] < 1 || nc[x] < 1 || nr[x] + h[x] - 1 > l || nc[x] + w[x] - 1 > l)
                return false;

            // 해당 범위에 벽이 있으면 움직일 수 없으므로 false
            // 여기서 아예 피해 값을 더해놓음
            for(int i = nr[x]; i <= nr[x] + h[x] - 1; i++) {
                for(int j = nc[x]; j <= nc[x] + w[x] - 1; j++) {
                    if(map[i][j] == 1) damaged[x]++;
                    if(map[i][j] == 2) return false;
                }
            }

            // 충돌하는 다음 knight 있는지 확인
            for(int i = 1; i <= n; i++) {
                //이미 움직인 애거나 죽은 친구 
                if(is_moved[i] || k[i] <= 0) continue;
                if(r[i] > nr[x] + h[x] - 1 || nr[x] > r[i] + h[i] - 1 || c[i] > nc[x] + w[x] - 1 || nc[x] > c[i] + w[i] - 1) continue;

                // 이동하는 친구는 boolean 배열에 true로 놓음
                is_moved[i] = true;
                q.add(i);
            }
        }

        damaged[idx] = 0;
        return true;
    }

    // 특정 조각을 지정된 방향으로 이동시키는 함수입니다.
    public static void move(int idx, int d) {
        if(k[idx] <= 0) return;

        // 이동이 가능한 경우, 실제 위치와 체력을 업데이트합니다.
        if(canMove(idx, d)) {
            for(int i = 1; i <= n; i++) {
                r[i] = nr[i];
                c[i] = nc[i];
                k[i] -= damaged[i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값을 받습니다.
        l = sc.nextInt();
        n = sc.nextInt();
        q = sc.nextInt();

        for(int i = 1; i <= l; i++)
            for(int j = 1; j <= l; j++)
                map[i][j] = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            r[i] = sc.nextInt();
            c[i] = sc.nextInt();
            h[i] = sc.nextInt();
            w[i] = sc.nextInt();
            k[i] = sc.nextInt();

            knightpower[i] = k[i];
        }

        for(int i = 1; i <= q; i++) {
            int idx = sc.nextInt();
            int d = sc.nextInt();
            move(idx, d);
        }

        // 결과를 계산하고 출력합니다.
        long ans = 0;
        for(int i = 1; i <= n; i++) {
            if(k[i] > 0) {
                ans += knightpower[i] - k[i];
            }
        }

        System.out.println(ans);
    }
}