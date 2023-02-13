package sk000801.백준.문자열;
import java.io.*;

public class 부분문자열 {
    static StringBuffer sb = new StringBuffer("");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        while((s = br.readLine()) != null) {
            String[] ss = s.split(" ");
            
            int idx = 0;
            for(int i = 0; i < ss[1].length(); i++) {
                if(ss[0].charAt(idx) == ss[1].charAt(i)) idx++;
                if(idx == ss[0].length()) break;
            }
            if(idx == ss[0].length()) sb.append("Yes\n");
            else sb.append("No\n");
        }

        System.out.println(sb);
    }
}
