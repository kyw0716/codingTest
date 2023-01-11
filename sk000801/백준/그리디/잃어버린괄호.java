package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

public class 잃어버린괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("-");
        List<Integer> nums = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < s.length; i++) {
            if(s[i].contains("+")) {
                String[] ss = s[i].split("\\+"); //처음안사실
                int n = 0;
                for(int j = 0; j < ss.length; j++) {
                    n += Integer.parseInt(ss[j]);
                }
                nums.add(n);
            } else {
                nums.add(Integer.parseInt(s[i]));
            }
        }

        answer += nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            answer -= nums.get(i);
        }

        System.out.println(answer);
    }
}
