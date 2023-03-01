package sk000801.백준.구현;
import java.io.*;
import java.util.*;

public class 캐슬디펜스2 {
    static int n, m, d;
    static int[][] castle;
    static int[] goong = new int[3];
    static List<int[]> list = new ArrayList<>();
    static int max = 0;
    public static class Monster implements Comparable<Monster> {
        int x, y, d;
        public Monster(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
        @Override
        public int compareTo(Monster m) {
            if(this.d == m.d) return this.y-m.y;
            else return this.d-m.d;
        }
    }
    public static void locate(int depth, int start) {
        if(depth == 3) {
            List<int[]> tmp = new ArrayList<>();
		    for (int i = 0; i < list.size(); i++) {
                int[] cur = list.get(i);
                tmp.add(new int[] { cur[0], cur[1] });
            }
            attack(tmp);
            return;
        }

        for(int i = start; i <= m; i++) {
            goong[depth] = i;
            locate(depth+1, i+1);
        }
    }
    public static void attack(List<int[]> list) {
        int count = 0;

        while(true) {
            if(list.isEmpty()) break;

            List<int[]> target = new ArrayList<>(); //공격하고 싶은 적의 좌표

            for(int x = 0; x < 3; x++) {
                PriorityQueue<Monster> pq = new PriorityQueue<>();

                for(int i = 0; i < list.size(); i++) {
                    int[] cur = list.get(i);
                    int dist = Math.abs(cur[0]-n)+Math.abs(cur[1]-goong[x]);
                    if(dist<=d) pq.add(new Monster(cur[0], cur[1] , dist));
                }

                if(!pq.isEmpty()) {
                    Monster monster = pq.poll();
                    boolean check = false; // 다른 궁수가 잡으려 하는지
                    for(int i = 0; i < target.size(); i++) {
                        int[] cur = target.get(i);
                        if(monster.x == cur[0] && monster.y == cur[1]) check = true;
                    }
                    if(!check) {
                        target.add(new int[] {monster.x, monster.y});
                    }
                }
            }

            for(int i = 0; i < target.size(); i++) { //궁수가 잡을 수 있는 적 제거
                for(int j = list.size()-1; j >= 0; j--) {
                    if(target.get(i)[0] == list.get(j)[0] 
                        && target.get(i)[1] == list.get(j)[1]) {
                            list.remove(j);
                            count++;
                            break;
                    }
                }
            }

            for(int i = list.size()-1; i >= 0; i--) { //남아있는 적 이동
                    list.get(i)[0]++;
                    if(list.get(i)[0] == n) list.remove(i);
            }

            max = Math.max(max, count);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);
        castle =  new int[n][m];

        for(int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                castle[i][j] = Integer.parseInt(s[j]);
                if(castle[i][j] == 1) list.add(new int[]{i, j});
            }
        }

        locate(0, 0);

        System.out.println(max);
    }
}
