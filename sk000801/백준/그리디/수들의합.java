package sk000801.백준.그리디;
import java.io.*;

public class 수들의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long s = Long.parseLong(br.readLine());
        long answer = 0;
        
        for(long i = 1; i <= s; i++) {
            if(s == 1 || s == 2) {System.out.println(1); return;}
            if(s<=i*(i+1)/2) {answer = i; break;}
        }
        
        if(s==answer*(answer+1)/2) System.out.println(answer);
        else System.out.println(answer-1);
    }
}
