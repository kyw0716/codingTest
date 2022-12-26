import java.util.Scanner;
 // 틀림!!!!!!!!!!!!!!!!!!!!
public class 체스판_다시_칠하기 {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();
 
		char[][] arr = new char[N][M];

        char[][] b = {{'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        };

        char[][] w = {{'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'}
        };
 
		for(int i = 0; i < N; i++) {
            String s  = in.nextLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int min = 64;

        for(int i = 0; i < N-7; i++) {
            for(int p = 0; p < M-7; p++) {
                int count1 = 0;
                int count2 = 0;
                for(int j = i; j <= i+7; j++) {
                    for(int k = p; k <= p+7; k++) {
                        if(arr[j][k] != b[j-i][k-p]) count1++;
                        if(arr[j][k] != w[j-i][k-p]) count2++;
                    }
                }
                int min1 = Math.min(count1, count2);
                min = Math.min(min, min1);
            }
        }

        System.out.println(min);
    }
}

// 열 인덱스 -> 0~7 / 1~8 / 2~9 / 3~10 
// 이렇게 하나 열을 다 돌면 행을 0~7 -> 1~8로 