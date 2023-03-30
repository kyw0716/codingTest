package sk000801.LEVEL2;
import java.util.*;

//13분 - 플로이드 워셜 활용해서 풀었다.. 
class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] dist = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 1_000_000);
            dist[i][i] = 0;
        }    
        
        for(int i = 0; i < road.length; i++) {
            if(dist[road[i][0]][road[i][1]] != Integer.MAX_VALUE) {
                dist[road[i][0]][road[i][1]] = Math.min(road[i][2], dist[road[i][0]][road[i][1]]);
                dist[road[i][1]][road[i][0]] = Math.min(road[i][2], dist[road[i][1]][road[i][0]]);
            } else {
                dist[road[i][0]][road[i][1]] = road[i][2];
                dist[road[i][1]][road[i][0]] = road[i][2];
            }
            
        }
    
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                for(int r = 1; r <= N; r++) {
                    if(i == j || j == r || i == r) continue;
                    if(dist[j][r] > dist[j][i]+dist[i][r]) {
                        dist[j][r] = dist[j][i]+dist[i][r];
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 1; i <= N; i++) {
            if(dist[1][i] <= K) answer++;
        }
        
        return answer;
    }
}