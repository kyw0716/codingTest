package sk000801.백준.그래프;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/2170
//라인 스위핑의 대표적 알고리즘
//다 입력받은 뒤 값을 정렬해도 되지만, PriorityQueue를 이용해 정렬!
public class 선긋기 {
    public static class Line implements Comparable<Line> {
        int start; int fin;
        public Line(int start, int fin) {
            this.start = start;
            this.fin = fin;
        }

        @Override
        public int compareTo(Line line) {
            if(this.start==line.start) return this.fin-line.fin;
            return this.start-line.start;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Line> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            pq.add(new Line(Math.min(a,b), Math.max(a,b)));
        }

        int start = pq.peek().start;
        int fin = pq.peek().fin;
        int result = 0;
        pq.poll();
        while(!pq.isEmpty()) {
            Line cur = pq.poll();
            if(cur.start > fin) { //이전 선과 현재 선에 연결고리가 없을 때
                result += fin-start; //결과에 이전 선을 그냥 더해줌 
                start = cur.start; //시작, 끝 값을 갱신시켜줌
                fin = cur.fin;
                continue;
            }
            fin = Math.max(fin, cur.fin); //연결돼있다면 끝 값만 갱신시켜줌
        }
        
        System.out.println(result+fin-start);
    }
}
