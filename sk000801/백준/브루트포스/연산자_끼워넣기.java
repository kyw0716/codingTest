import java.util.*;

public class 연산자_끼워넣기 {

    static int N;
    static int[] num;
    static int[] yeonsan = new int[4];
    static int max =  Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void dfs(int n, int index) {

        if(index == N) {
            max = Math.max(n, max);
            min = Math.min(n, min);
            return;
        }

        for(int i = 0; i < yeonsan.length; i++) {
            if(yeonsan[i] > 0) {
                yeonsan[i]--;
                switch(i) {
                    case 0: dfs(n+num[index], index+1);break;
                    case 1: dfs(n-num[index], index+1);break;
                    case 2: dfs(n*num[index], index+1);break;
                    case 3: dfs(n/num[index], index+1);break;
                    }
                yeonsan[i]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        num = new int[N];

        for(int i = 0; i < N; i++) {
            num[i] = in.nextInt();
        }

        for(int i = 0; i < 4; i++) {
            yeonsan[i] = in.nextInt();
        }
        
        dfs(num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
}

//dfs 알고리즘이 사용되나보다,,