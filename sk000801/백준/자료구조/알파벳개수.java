import java.util.*;
import java.io.*;

public class 알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuffer sb = new StringBuffer("");

        for(char c = 97; c <= 122; c++) {
            int count = 0;
            for(int i = 0; i < s.length(); i++) {     
                if(s.charAt(i) == c) count++;
            }
            sb.append(String.valueOf(count));
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
