package sk000801.코드트리;
import java.io.*;
import java.util.*;

// 풀이를 보면서 풀어도 2시간은 족히 걸렸다.. 이게 맞나
public class 포탑트리 {
    public static class Point {
        int x, y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    
    }

	static int n, m, k;
	static int[][] potap;
	static int[][] attackTime; 
	static boolean[][] isAttacked; 

	static int[] attacker;
	static int[] target;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[] dx2 = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy2 = { 1, 0, -1, 0, -1, 1, -1, 1 };

	public static void setAttacker(int turn) {
		int power = 5001;
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (potap[i][j] <= 0)	continue;

				if(potap[i][j] < power) {
					power = potap[i][j];
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] > attackTime[x][y]) {
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] == attackTime[x][y] && i+j > x+y) {
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] == attackTime[x][y] && i+j == x+y && j > y) {
					x = i;
					y = j;
				}
			}
		}

		attacker = new int[]{x, y};
		potap[attacker[0]][attacker[1]] += n + m;
		isAttacked[attacker[0]][attacker[1]] = true;
		attackTime[attacker[0]][attacker[1]] = turn;
	}

	public static void attack() {
		int power = -1;
		int x = 0, y = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (potap[i][j] <= 0)	continue;
				if (i == attacker[0] && j == attacker[1])	continue;

				if(potap[i][j] > power) {
					power = potap[i][j];
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] < attackTime[x][y]) {
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] == attackTime[x][y] && i+j < x+y) {
					x = i;
					y = j;
					continue;
				} else if(potap[i][j] == power && attackTime[i][j] == attackTime[x][y] && i+j == x+y && j < y) {
					x = i;
					y = j;
				}
			}
		}

		target = new int[]{x, y};
		isAttacked[target[0]][target[1]] = true;

		if (!laser(attacker, target)) {
			bomb(attacker, target);
		}
	}

	static boolean isFinish() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (potap[i][j] <= 0)	continue;
				count++;
			}
		}
		return count == 1;
	}


	public static boolean laser(int[] attacker, int[] target) {
		boolean[][] visited = new boolean[n][m]; 
		// 역추적을 위한 배열
		Point[][] come = new Point[n][m]; 

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(attacker[0], attacker[1]));
		visited[attacker[0]][attacker[1]] = true;

		while (!q.isEmpty()) {
			Point pair = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = (pair.x + dx[d] + n) % n;
				int ny = (pair.y + dy[d] + m) % m;
				if (visited[nx][ny])	continue;
				if (potap[nx][ny] <= 0)	continue;
				come[nx][ny] = new Point(pair.x, pair.y);
				visited[nx][ny] = true;
				q.add(new Point(nx, ny));
			}
		}

		if (!visited[target[0]][target[1]])
			return false;

		int x = target[0], y = target[1];
		while (x != attacker[0] || y != attacker[1]) {
			int power = potap[attacker[0]][attacker[1]] / 2;
			if (x == target[0] && y == target[1]) {
				power = potap[attacker[0]][attacker[1]];
			}
			potap[x][y] -= power;
			isAttacked[x][y] = true;
			Point pair = come[x][y]; // 역추적
			x = pair.x;
			y = pair.y;
		}
		return true;
	}

	public static void bomb(int[] attacker, int[] target) {
		potap[target[0]][target[1]] -= potap[attacker[0]][attacker[1]];
		int halfPower = potap[attacker[0]][attacker[1]] / 2;
		for (int d = 0; d < 8; d++) {
			int nx = (target[0] + dx2[d] + n) % n;
			int ny = (target[1] + dy2[d] + m) % m;
			if (nx == attacker[0] && ny == attacker[1])	continue;
			potap[nx][ny] -= halfPower;
			isAttacked[nx][ny] = true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		potap = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				potap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		attackTime = new int[n][m];

		for (int i = 1; i <= k; i++) {
			if (isFinish())
				break;

			isAttacked = new boolean[n][m];

			setAttacker(i);

			attack();

			for (int r = 0; r < n; r++) {
				for (int j = 0; j < m; j++) {
					if (potap[r][j] == 0) continue;
					if (isAttacked[r][j]) continue;
					potap[r][j] += 1;
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (potap[i][j] > max) {
					max = potap[i][j];
				}
			}
		}
		System.out.println(max);
	}
}
