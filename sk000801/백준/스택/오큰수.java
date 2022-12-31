import java.util.*;
import java.io.*;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        StringBuffer s = new StringBuffer("");
        int[] nums = new int[n];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //띄어쓰기 기준으로 토큰화
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n-1; i >= 0; i--) {
            int num = nums[i];
            while(!stack.empty() && stack.peek() <= num) {
               stack.pop();
            }
            if(stack.empty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(num);
        }

        for(int i = 0; i < n; i++) {
            s.append(answer[i]).append(" ");
        }

        System.out.println(s);
    }
}
