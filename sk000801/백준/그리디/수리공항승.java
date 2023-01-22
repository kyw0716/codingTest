package sk000801.백준.그리디;
import java.util.*;

public class 수리공항승 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int l = in.nextInt();
        List<Integer> tape = new ArrayList<>();
        int dis = 0;
        int answer = 0;

        for(int i = 0; i < n; i++) {
            tape.add(in.nextInt());
        }
        tape.sort(Comparator.naturalOrder());

        for(int i = 0; i < n-1; i++) {
            dis += Math.abs(tape.get(i+1)-tape.get(i));
            if(l <= dis) {answer++; dis = 0;}
        }

        System.out.println(answer+1);
    }
}
