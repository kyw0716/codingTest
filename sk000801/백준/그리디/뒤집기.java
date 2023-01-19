package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

public class 뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");
        Stack<String> st = new Stack<>();
        StringBuffer sb = new StringBuffer("");
        st.push(s[0]);

        for(int i = 1; i < s.length; i++) {
            if(!st.peek().equals(s[i])) {
                sb.append(st.pop());
                st.push(s[i]);
            }
        }
        sb.append(st.pop());    

        int count = 0;
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '1') count++;
        }

        System.out.println(Math.min(sb.length()-count, count));
    }
}