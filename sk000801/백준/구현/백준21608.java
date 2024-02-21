package sk000801.백준.구현;
import java.util.*;

// 인접한 칸 중에 좋아하는 학생이 많은 칸으로 이동
// 여러개면 비어있는 칸이 많은 칸으로 이동
// 여러개면 행/열의 번호가 작은 칸으로 이동

// 만족도 계산할 때 좋아하는 학생의 수 대로 10의 거듭제곱 값이 만족도 

//https://www.acmicpc.net/problem/21608

public class 백준21608 {
    static int n;
    static int[][] room;
    static Map<Integer, int[]> fav = new HashMap<>();

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static class Seat {
        int x; int y; int count; int friend;
    
        public Seat(int x, int y, int count, int friend) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.friend = friend;
        }
    }

    public static void find(int student) {
        int[] friends = fav.get(student);
        List<Seat> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int friend = 0;
                int empty = 0;

                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx < 0|| nx >= n || ny < 0 || ny >= n) continue;

                    for(int d = 0; d < 4; d++) {
                        if(room[nx][ny] == friends[d]) {
                            friend++;
                        }
                    }

                    if(room[nx][ny] == 0) empty++;
                }

                list.add(new Seat(j, i, empty, friend));
            }
        }

        list.sort((a, b) -> {
            if(a.friend == b.friend) {
                if(a.count == b.count) {
                    if(a.y == b.y) return a.x-b.x; 
                    return a.y-b.y;
                }
                return a.count-b.count;
            }
            return a.friend-b.friend;
        });

        for(int i = 0; i < list.size(); i++) {
            Seat cur = list.get(i);
            if(room[cur.y][cur.x] == 0) {
                room[cur.y][cur.x] = student;
                return;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        room = new int[n][n];

        for(int i = 1; i <= n*n; i++) {
            int student = in.nextInt();
            
            fav.put(student, new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()});
            find(student);
        }

        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int student = room[i][j];
                int[] friends = fav.get(student);
                int count = 0;

                for(int r = 0; r < 4; r++) {
                    int nx = i+dx[r];
                    int ny = j+dy[r];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    for(int d = 0; d < 4; d++) {
                        if(room[nx][ny] == friends[d]) {
                            count++;
                            break;
                        }
                    }

                    if(count == 1) answer += 1;
                    else if(count == 2) answer += 10;
                    else if(count == 3) answer += 100;
                    else if(count == 4) answer += 1000;
                }
            }
        }

        System.out.println(answer);
    }   
}
