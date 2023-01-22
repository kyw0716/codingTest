package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

public class 강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] bang = new int[n][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            bang[i][0] = Integer.parseInt(s[0]);
            bang[i][1] = Integer.parseInt(s[1]);
        }
        
        /** 시작 시간을 기준으로 정렬*/
        Arrays.sort(bang, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1]-b[1]; 
                //시작 시간이 같다면 종료 시간이 이른것부터 정렬
                return a[0]-b[0];
            }
        });

        pq.offer(bang[0][1]);
        for(int i = 1; i < n; i++) {
            //우선순위 큐에서 가장 작은 종료 시각
            if(pq.peek() <= bang[i][0]) pq.poll();
            pq.offer(bang[i][1]);
        }

        System.out.println(pq.size());
    }
}
