import java.util.*;
public class 부등호 {
    static int n;
    static String[] d;
    static boolean[] visited;
    static List<Integer> answer;
    static String max;
    static String min;

    public static void dfs(String num, int index) {
        if(index == n+1) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                if(d[i].equals(">")) {
                    if(Character.getNumericValue(num.charAt(i))>Character.getNumericValue(num.charAt(i+1))) {
                        count++;
                    }
                } else {
                    if(Character.getNumericValue(num.charAt(i))<Character.getNumericValue(num.charAt(i+1))) {
                        count++;
                    }
                }
            }
            if(count == n) {
                if(Long.parseLong(min) > Long.parseLong(num)) min = num;
                if(Long.parseLong(max) < Long.parseLong(num)) max = num;
            }
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(num+String.valueOf(i), index+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = Integer.parseInt(in.nextLine());
        d = in.nextLine().split(" ");
        visited = new boolean[10];
        answer = new ArrayList<>();
        max = String.valueOf(Long.MIN_VALUE);
        min = String.valueOf(Long.MAX_VALUE);

        dfs("", 0);

        System.out.println(max);
        System.out.println(min);
    }   
}
