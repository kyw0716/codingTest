package sk000801.백준.복습;
import java.io.*;

//어떤 기준을 잡아야 한다...
//처음에는 두 배열에 값을 담아 비교했는데
//아예 클래스로 두 점수중 하나를 기준으로 오름차순 시켜놓고 count해도 될 듯
public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer("");

        int tc = Integer.parseInt(br.readLine());
        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n+1];

            for(int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                rank[Integer.parseInt(s[0])] = Integer.parseInt(s[1]);
            }

            int min = rank[1];
            //면접성적이 1등일때는 무조건 가능하므로 1을 최솟값으로 놓고 시작한다

            int count = 0;
            for(int j = 2; j <= n; j++) {
                if(rank[j] < min) {
                    min = rank[j];
                    count++;
                }
            }
            sb.append(count+1).append("\n");
        }

        System.out.println(sb);
    }
}
