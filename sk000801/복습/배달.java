package sk000801.복습;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/12978
//19분
//푸는 방식은 똑같은데 충분히 높은 값을 주는 데에 문제가 있었다
//거리가 가지는 최댓값이 10000이고, 최대 마을이 50개이기 때문에 50만 보다는 큰 숫자가 최댓값으로 주어져야 한다
//그렇다고 Integer.MAX_VALUE를 막 주진 말자. overflow가 발생한 거 같다
public class 배달 {
    public static int solution(int n, int[][] road, int k) {
        int answer = 0;
        int[][] deliver = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) deliver[i][j] = 0;
                else deliver[i][j] = 1000000;
            }
        }
        for(int i = 0; i < road.length; i++) {
            deliver[road[i][0]][road[i][1]] = Math.min(road[i][2], deliver[road[i][0]][road[i][1]]);
            deliver[road[i][1]][road[i][0]] = Math.min(road[i][2], deliver[road[i][1]][road[i][0]]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int r = 1; r <= n; r++) {
                    if(i==j || j==r || i==r) continue;
                    if(deliver[j][r] > deliver[j][i]+deliver[i][r]) {
                        deliver[j][r] = deliver[j][i]+deliver[i][r];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(deliver[1][i] <= k) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int n1 = 5; int k1 = 3;
        int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(solution(n1, road1, k1));
    }
}
