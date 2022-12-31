import java.util.*;
import java.io.*;

public class 떡먹는호랑이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= k/2; i++) {
            for(int j = i+1; j < k; j++) {
                int[] gaesu = new int[d]; 
                gaesu[0] = i;
                gaesu[1] = j;
                for(int r = 2; r < d; r++) {
                    gaesu[r] = gaesu[r-2]+gaesu[r-1];  
                }
                if(gaesu[d-1] == k) {
                    System.out.println(gaesu[0]);
                    System.out.println(gaesu[1]);
                    System.exit(0);
                }
            }
        }
    }
}
