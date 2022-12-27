import java.util.Scanner;

public class 부분수열의_합 {
    static int n;
    static int s;
    static int[] num;
    static int count;

    public static void dfs(int index, int sum) {
        if(index == n) {
            if(sum == s) count++;
            return;
        }
        dfs(index+1, sum+num[index]);
        dfs(index+1, sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        s = in.nextInt();
        num = new int[n];
        count = 0;

        for(int i = 0; i < n; i++) {
            num[i] = in.nextInt();
        }

        dfs(0, 0);

        System.out.println(s == 0 ? count-1 : count);
    }
}
