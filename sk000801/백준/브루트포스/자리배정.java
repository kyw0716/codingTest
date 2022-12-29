import java.util.*;

public class 자리배정 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int r = in.nextInt();
        int c = in.nextInt();
        int order = in.nextInt();

        int num = 1;
        int cx = 0;
        int cy = 0;

        int[][] arr = new int[r][c];
        arr[0][0] = num;

        int[] mx = {0,1,0,-1};
        int[] my = {1,0,-1,0};

        if(order == 1) {
            System.out.println("1 1");
            return;
        }
        if(c*r >= order) {
            for(int i = 0; i < c+r; i++) {
                for(;;) {
                    int nx = cx + mx[i%4];
                    int ny = cy + my[i%4];
                    if(!(nx < 0) && !(nx >= r) && !(ny < 0) && !(ny >= c) && arr[nx][ny] == 0) {
                        num++;
                        arr[nx][ny] = num;
                        if(num == order) {
                            System.out.println((nx+1)+ " "+ (ny+1));
                            return;
                        }
                        cx = nx;
                        cy = ny;
                    }
                    else break; 
                }
            }
        } else {
            System.out.println(0);
            return;
        }
    }
}

//달팽이 문제!!!
