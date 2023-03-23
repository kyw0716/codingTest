package sk000801.LEVEL2;
import java.util.*;

//백준 숨바꼭질 문제와 비슷할거 같아 bfs로 풀었는데 에러가 나서
//dp로 접근하라는 힌트를 얻고 점화식을 세웠더니 바로 답이 풀린다
//이게 풀이는 어려운게 아닌데 아이디어를 떠올리는게 여전히 어려운 거 같다ㅠㅠ
class Solution {
    public int solution(int x, int y, int n) {
        if(x==y) return 0;
        int[] dp = new int[y+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[x] = 0;
        for(int i = x; i < y+1; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            
            if(i+n <= y) dp[i+n] = Math.min(dp[i+n], dp[i]+1);
            if(i*2 <= y) dp[i*2] = Math.min(dp[i*2], dp[i]+1);
            if(i*3 <= y) dp[i*3] = Math.min(dp[i*3], dp[i]+1);
        }
        
        return dp[y] == Integer.MAX_VALUE ? -1 : dp[y];
    }
}