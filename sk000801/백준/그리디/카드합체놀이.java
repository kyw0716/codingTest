package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

import javax.xml.namespace.QName;

public class 카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while(m-->0) {
            long a = pq.poll();
            long b = pq.poll();

            pq.add(a+b);
            pq.add(a+b);
        }

        long ans = 0;
        for(int i = 0; i < n; i++) {
            ans += pq.poll();
        }

        System.out.println(ans);
    }
}
