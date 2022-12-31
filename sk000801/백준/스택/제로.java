import java.util.*;

public class 제로 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt();
        int answer = 0;

        Stack<Integer> num = new Stack<>();

        for(int i = 0; i < k; i++) {
            int n = in.nextInt();

            if(n != 0) {
                num.push(n);
            } else {
                num.pop();
            }
        }

        while(!num.empty()) {
            answer += num.peek();
            num.pop();
        }

        System.out.println(answer);
    }
}
