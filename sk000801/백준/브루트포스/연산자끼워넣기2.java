import java.util.*;

public class 연산자끼워넣기2 {
    static int N;
    static int[] num;
    static int[] yeonsan = new int[4];
    static long max;
    static long min;

    public static void dfs(int n, int depth, int index) {
        if(index == N) {
            if(depth != 0) {
                max = Math.max(n, max);
                min = Math.min(n, min);
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            if(yeonsan[i] > 0) {
                yeonsan[i]--;
                switch(i) {
                    case 0:
                        dfs(n+num[index], depth+1, index+1);
                        break;
                    case 1:
                        dfs(n-num[index], depth+1, index+1);
                        break;
                    case 2:
                        dfs(n*num[index], depth+1, index+1);
                        break;
                    case 3:
                        dfs(n/num[index], depth+1, index+1);
                        break;
                }
                yeonsan[i]++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        num = new int[N];
        yeonsan = new int[4];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            yeonsan[i] = in.nextInt();
        }

        dfs(num[0], 0, 1);

        System.out.println(max);
        System.out.println(min);
    }
}
