package sk000801.백준.복습;
import java.util.*;

//덧셈, 뺄셈, 곱셈, 나눗셈
//시작값을 첫번째 인덱스로 설정해야함,, 왜?
public class 연산자끼워넣기 {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int n;
    static int[] num;
    static int[] yeonsan;
    public static void dfs(int depth, int result) {
        if(depth == n) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for(int i = 0; i < 4; i++) {
             if(yeonsan[i]>0) {
                yeonsan[i]--;
                switch(i) {
                    case 0: dfs(depth+1, result+num[depth]);break;
                    case 1: dfs(depth+1, result-num[depth]);break;
                    case 2: dfs(depth+1, result*num[depth]);break;
                    case 3: dfs(depth+1, result/num[depth]);break;
                }
                yeonsan[i]++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        num = new int[n];
        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }
        Arrays.sort(num);
        yeonsan = new int[4];
        for(int i = 0; i < 4; i++) {
            yeonsan[i] = in.nextInt();
        }

        dfs(1, num[0]);

        System.out.println(max);
        System.out.println(min);
    }
}
