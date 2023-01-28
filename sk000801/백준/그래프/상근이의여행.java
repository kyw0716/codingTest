package sk000801.백준.그래프;
import java.util.*;

//https://www.acmicpc.net/problem/9372
//상근이 넌 나에게 트릭을 줘써
public class 상근이의여행 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int test = Integer.parseInt(in.nextLine());
        StringBuffer sb = new StringBuffer("");

        while(test-->0) {
            String[] s = in.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            for(int i = 0; i < m; i++) {
                in.nextLine();
            }

            sb.append(n-1+"\n");
        }
        
        System.out.println(sb);
    }
}
