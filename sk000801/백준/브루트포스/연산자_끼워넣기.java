import java.util.*;

public class 연산자_끼워넣기 {

    static int N;
    static int[] num;
    static int[] yeonsan = new int[4];
    static int max =  Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public static void dfs(int n, int index) {

        if(index == N) { //인덱스가 깊이 만큼 도달했을 때
            max = Math.max(n, max);
            min = Math.min(n, min);
            return;
        }

        for(int i = 0; i < yeonsan.length; i++) {
            if(yeonsan[i] > 0) {
                yeonsan[i]--; //해당 인덱스를 거치므로 값을 1 줄여줌
                switch(i) { //재귀호출
                    case 0: dfs(n+num[index], index+1);break;
                    case 1: dfs(n-num[index], index+1);break;
                    case 2: dfs(n*num[index], index+1);break;
                    case 3: dfs(n/num[index], index+1);break;
                    }
                yeonsan[i]++; //재귀 호출이 모두 끝났을 때 값을 되돌림
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