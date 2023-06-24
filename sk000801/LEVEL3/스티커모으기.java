package sk000801.LEVEL3;
public class 스티커모으기 {
    //첫번째 원소 포함 / 두번째 원소 포함
    //32분
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        
        int[][] dp = new int[2][sticker.length];
        //첫번째 값을 거쳐갈 때
        dp[0][0] = sticker[0]; dp[0][1] = sticker[0];
        for(int i = 2; i < sticker.length-1; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2]+sticker[i]);
        }
        
        //첫번째 값을 거치지 않을 때 (마지막 값을 거칠 수 있음)
        dp[1][0] = 0; dp[1][1] = sticker[1];
        for(int i = 2; i < sticker.length; i++) {
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2]+sticker[i]);
        }
        
        return Math.max(dp[0][sticker.length-2], dp[1][sticker.length-1]);
    }
}
