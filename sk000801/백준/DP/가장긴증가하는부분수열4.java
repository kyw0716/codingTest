package sk000801.백준.DP;
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n+1];
        int[] gaesu = new int[n+1];
        StringBuffer sb = new StringBuffer("");

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        if(n==1) {
            System.out.println(1);
            System.out.println(num[1]);
            return;
        }

        int max = 0;
        gaesu[1] = 1;
        for(int i = 2; i <= n; i++) {
            gaesu[i] = 1;
            for(int j = 1; j < i; j++) {
                if(num[j]<num[i]) {
                        gaesu[i] = Math.max(gaesu[j]+1, gaesu[i]);
                    }  
            }
            max = Math.max(max, gaesu[i]);
        }

        sb.append(max+"\n");   
        
        Stack<Integer> s = new Stack<>();
        for(int i = n; i >= 1 ;i--) {
            if(gaesu[i] == max) {
                s.push(num[i]);
                max--;
            }
        }

        while(!s.isEmpty()) {
            sb.append(s.pop());
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
