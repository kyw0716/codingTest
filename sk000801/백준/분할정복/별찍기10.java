package sk000801.백준.분할정복;
import java.io.*;

//https://www.acmicpc.net/problem/2447
//9로 칸이 구분됨
//가운데 칸은 무조건 공백
public class 별찍기10 {
    static int n;
    static char[][] arr;
    static StringBuffer sb = new StringBuffer("");
    public static void divide(int r, int j, int s, boolean isCenter) {
        if(isCenter) { //분리된 9칸 중 5번째 칸일 때
            for(int i = r; i < r+s; i++) {
                for(int p = j; p < j+s; p++) {
                    arr[i][p] = ' '; //빈칸을 넣어줌
                }
            }
            return;
        }

        if(s==1) { //그 경우가 아니고 모두 쪼개진 경우일 때
            arr[r][j] = '*';
            return;
        }

        int size = s/3;
        int count = 0; //9개의 블록 중 특정 조건의 값을 계산해주는 경우
        for(int x = r; x < r+s; x += size) {
            for(int y = j; y < j+s; y += size) {
                count++;
                if(count==5) divide(x, y, size, true);
                else divide(x, y, size, false);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        
        divide(0, 0, n, false);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }   
}
