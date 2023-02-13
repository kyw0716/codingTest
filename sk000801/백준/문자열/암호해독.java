package sk000801.백준.문자열;
import java.io.*;

//https://www.acmicpc.net/problem/14584
//소문자 97~122
public class 암호해독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        char[] c = new char[s.length()];
        int n = Integer.parseInt(br.readLine());
        String[] word = new String[n];
        for(int i = 0; i < n; i++) {
            word[i] = br.readLine();
        }
        
        for(int i = 0; i < 26; i++) {
            String ss = "";
            for(int j = 0; j < s.length(); j++) {
                ss += (char)((s.charAt(j)-'a'+i)%26+'a');
            }
            for(int j = 0; j < n; j++) {
                if(ss.contains(word[j])) {
                    System.out.println(ss);
                    return;
                }
            }
        }


    }
}
