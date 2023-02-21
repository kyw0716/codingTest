package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//우선순위큐!!!!!!!!!!!!!!!!
public class 강의실배정 {
    static int n;
    static List<int[]> lec = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            lec.add(new int[]{a, b});
        }

        lec.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            }
        });

        pq.add(lec.get(0)[1]);
        for(int i = 1; i < n; i++) {
            if(pq.peek() <= lec.get(i)[0]) pq.poll();
            pq.add(lec.get(i)[1]);
        }

        System.out.println(pq.size());
    }
}
