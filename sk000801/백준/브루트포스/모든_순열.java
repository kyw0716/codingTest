import java.util.*;

public class 모든_순열 {
    static int n;
    static int[] arr;
    static List<Integer> answer;

    public static void perm(int depth) {
        if(depth == n) {
            String[] num = new String[n];
            for(int i = 0; i < n; i++) {
               num[i] = String.valueOf(arr[i]);
            }
            answer.add(Integer.parseInt(String.join("", num)));
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(i, depth);
            perm(depth+1);
            swap(i, depth);
        }
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        arr = new int[n];
        answer = new ArrayList<>();

        for(int i = 1; i <= n ; i++) {
            arr[i-1] = i;
        } 

        perm(0);

        Collections.sort(answer);

        for(int i = 0; i < answer.size(); i++) {
            String num = String.valueOf(answer.get(i));
            String[] nums = num.split("");
            System.out.println(String.join(" ", nums));
        }
    }
}
