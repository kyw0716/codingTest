package sk000801.백준.복습;
import java.util.Scanner;

public class 자리배정 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int c = in.nextInt(); //가로
		int r = in.nextInt(); //세로, 이 값이 기준??
		int person = in.nextInt();
		if(c*r < person) {
			System.out.println(0);
			return;
		} 
		if(person == 1) {
			System.out.println("1 1");
			return;
		}
		
		int[][] arr = new int[r][c];
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
		int num = 1;

		int x = 0; int y = 0; //초기값
		arr[x][y] = num++;
		while(num <= r*c) {
			for(int i = 0; i < 4; i++) {
				while(true) {
					x += dx[i];
					y += dy[i];
					if(x<0||x>=r||y<0||y>=c||arr[x][y] != 0) {
						x -= dx[i];
						y -= dy[i];
						break;
					}
					arr[x][y] = num++;
					if(arr[x][y] == person) {
						System.out.println((y+1)+" "+(x+1));
						return;					
					}
				}	
			}
		}	
	}
}

