package sk000801.백준.브루트포스;
import java.io.*;
import java.util.*;

public class 탈출 {
    static int r, c;
    static String[][] road;
    static Queue<int[]> q = new LinkedList<>();
    static Queue<int[]> water = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int answer = 987654;

    public static void bfs() {
        while(!q.isEmpty()) {
            int size = water.size();
            for(int i = 0; i < size; i++) {
                int[] top = water.poll();
                for(int j = 0; j < 4; j++) {
                    int nx = top[0]+dx[j];
                    int ny = top[1]+dy[j];
                    if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                    if(road[nx][ny].equals(".")) {
                        road[nx][ny] = "*";
                        water.add(new int[]{nx, ny});
                    }
                }
            }

            size = q.size();
            for(int i = 0; i < size; i++) {
                int[] top = q.poll();
                for(int j = 0; j < 4; j++) {
                    int nx= top[0]+dx[j];
                    int ny = top[1]+dy[j];
                    if(nx<0 || nx>=r || ny<0 || ny>=c) continue;
                    if(road[nx][ny].equals("D")) {
                        answer = Math.min(answer, top[2]+1);
                        return;
                    } 
                    if(road[nx][ny].equals(".")) {
                        road[nx][ny] = "S";
                        q.add(new int[]{nx, ny, top[2]+1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        road = new String[r][c];

        for(int i = 0; i < r; i++) {
            s = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                road[i][j] = s[j];
                if(road[i][j].equals("S")) q.add(new int[]{i,j,0});
                else if(road[i][j].equals("*")) water.add(new int[]{i,j});
            }
        }

        bfs();

        System.out.println(answer == 987654 ? "KAKTUS": answer);
    }
}

//한 시점에 큐에 들어있는 원소가 모두 같은 시간에 방문한 좌표들이라면
//그 다음 시점에 방문할 좌표는 지금 좌표로부터 이동할 수 있는 모든 좌표를 큐에 넣음
//현재 큐에 들어있는 좌표의 개수가 큐의 크기이므로 원소를 이 길이만큼 뽑고 큐에 다음 칸을 넣음
//이것을 물의 이동과 고슴도치의 이동에 대해 번갈아 수행하므로 시간이 유지됨..!