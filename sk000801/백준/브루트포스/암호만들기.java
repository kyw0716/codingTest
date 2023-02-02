package sk000801.백준.브루트포스;
import java.io.*;
import java.util.*;

public class 암호만들기 {
    static int l,c;
    static char[] al;
    // static char[] ans;
    static StringBuffer sb = new StringBuffer("");
    static boolean[] visited;
    // public static boolean check(char[] al) {
    //     int count1 = 0, count2 = 0;
    //     for(int i = 0; i < al.length; i++) {
    //         if(al[i] == 'a' || al[i] == 'e' || al[i] == 'i' || al[i] == 'o' || al[i] == 'u') 
    //             count1++;
    //         else count2++;
    //     }
    //     if(count1 < 1 || count2 < 2)  return false;
    //     return true;
    // } 
    public static void dfs(int idx, int depth) {
        if(depth==l) {
            int count1 = 0, count2 = 0;
            for(int i = 0; i < c; i++) {
                if(visited[i]) {
                    if(al[i] == 'a' || al[i] == 'e' || al[i] == 'i' || al[i] == 'o' || al[i] == 'u') 
                    count1++;
                    else count2++;
                }
            }
            if(count1 >= 1 && count2 >= 2) {
                for(int i = 0; i < c; i++) {
                    if(visited[i]) {
                        sb.append(al[i]);
                    }
                }
                sb.append("\n");
            }  
            // if(check(ans)) {
            //     sb.append(ans);
            //     sb.append("\n");
            // }
            return;
        }

        for(int i = idx; i < al.length; i++) {
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
            // if(!visited[i]) {
            //     // ans[depth] = al[i];
            //     visited[i] = true;
            //     dfs(idx+1, depth+1);
            //     visited[i] = false;
            // }
            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        al = new char[c];
        visited = new boolean[c];
        // ans = new char[l];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < c; i++) {
            al[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(al);

        dfs(0, 0);

        System.out.println(sb);
    }
}
