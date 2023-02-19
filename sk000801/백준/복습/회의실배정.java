package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//Comparator를 활용해 종료 시간이 더 빠른것부터 정렬
//종료시간이 같다면 시작 시간이 작은 것 먼저 정렬
public class 회의실배정 {
    static int n;
    static int[][] talk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        talk = new int[n][2];

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            talk[i][0] = Integer.parseInt(s[0]);
            talk[i][1] = Integer.parseInt(s[1]);
        }

        Arrays.sort(talk, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) return a[0]-b[0];
                return a[1]-b[1];
            }
        });

        int time = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(time<=talk[i][0]) {
                time = talk[i][0];
                count++;
            }
        }

        System.out.println(count);
    }
}
