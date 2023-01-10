package sk000801.백준.그리디;
import java.util.*;

public class 회의실배정 {
    static int n;
    static long[][] talk;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[][] talk = new int[n][2];
        int answer = 0;
        int time = 0;

        for(int i = 0; i < n; i++) {
            talk[i][0] = in.nextInt();
            talk[i][1] = in.nextInt();
        }

        Arrays.sort(talk, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] == b[1]) return a[0]-b[0]; 
                //종료 시간이 같다면 시작 시간이 이른 것으로 정렬
                return a[1]-b[1];
            }
        });

        for(int i = 0; i < n; i++) {
            if(time <= talk[i][0]) {
                time = talk[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}

//오 맞다 진짜 회의 시간이 짧은 친구들 먼저 넣기 시작하는게 이득일듯
