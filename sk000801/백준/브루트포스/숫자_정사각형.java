import java.util.*;
import java.util.stream.Stream;

public class 숫자_정사각형 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] ss = in.nextLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);
        int[][] size = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            size[i] = Stream.of(s).mapToInt(Integer::parseInt).toArray();
        }

        int max = 1;
        for(int i = 2; i <= Math.min(n, m); i++) {
            int gop = 0;
            for(int j = 0; j <= n-i; j++) {
                for(int r = 0; r <= m-i; r++) {
                    if(size[j][r] == size[j][r+i-1] && 
                    size[j+i-1][r] == size[j+i-1][r+i-1] && size[j][r+i-1] == size[j+i-1][r]) {
                        gop = i*i;
                        continue;
                    }
                }
            }
            max = Math.max(max, gop);
        }

        System.out.println(max);
    }
}

//3(0~2) 5(0~4) 
//         
