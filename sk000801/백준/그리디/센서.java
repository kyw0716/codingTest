package sk000801.백준.그리디;
import java.io.*;
import java.util.*;

// 두 거리 사이의 차이가 가장 큰 친구들부터 담아야 하나? ㅇㅇ
// 차이 배열을 따로 선언하여 내림차순으로 배열을 정렬함
// k개라면 가장 큰 차이는 무력화시키면 되므로 k-1 인덱스부터 차이를 더해주면 그게 최소!
public class 센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        if(k>=n) {System.out.println(0); return;}

        int[] sensor = new int[n];
        Integer[] diff = new Integer[n-1];
        int result = 0;

        String[] s = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(sensor);

        for(int i = 0; i < n-1; i++) {
            diff[i] = sensor[i+1]-sensor[i];
        }
        Arrays.sort(diff, Comparator.reverseOrder());
        //Compartor를 쓰기 위해서는 int가 아닌 Integer를 사용해야함

        for(int i = k-1; i < n-1; i++) {
            result += diff[i];
        }

        System.out.println(result);
    }
}

//0+2+5+0+0