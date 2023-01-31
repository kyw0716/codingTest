package sk000801.백준.그리디;
import java.util.*;

//잊지말기 맨앞과 맨뒤도 연관이 돼있음
//정렬한 뒤 차례대로 값을 새로운 배열에 앞뒤로 넣어줌
//https://www.acmicpc.net/problem/11497
public class 통나무건너뛰기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int tc = in.nextInt();

        for(int i = 0; i < tc; i++) {
            int n = in.nextInt();
            int[] height = new int[n];
            int[] num = new int[n];

            for(int j = 0; j < n; j++) {
                height[j] = in.nextInt();
            }
            Arrays.sort(height);

            int start = 0;
            int fin = n-1;
            for(int r = 0; r < n; r++) {
                if(r%2==0) {
                    num[start] = height[r];
                    start++;
                } else {
                    num[fin] = height[r];
                    fin--;
                }
            }

            int answer = 0;
            for(int p = 0; p < n-1; p++) {
                if(p==0) answer = Math.max(answer, Math.abs(num[0]-num[n-1]));
                answer = Math.max(answer, Math.abs(num[p]-num[p+1]));
            }

            System.out.println(answer);
        }
    }
}