package sk000801.LEVEL3;

//15분!! 3레벨 중에 가장 쉬운 문제일듯
//2차원 dp 배열을 만들어 값에 1을 곱할 때와 -1을 곱할 때를 비교
//다만 자료형 체크를 안해서 틀림;;
public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        for(int i = 0; i < sequence.length; i++) {
            if(i%2 == 0) {
                arr1[i] = sequence[i];
                arr2[i] = (-1)*sequence[i];
            } else {
                arr1[i] = (-1)*sequence[i];
                arr2[i] = sequence[i];
            }
        }
        
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = arr1[0]; dp[0][1] = arr2[0];
        for(int i = 1; i < sequence.length; i++) {
            dp[i][0] = Math.max(arr1[i], dp[i-1][0]+arr1[i]);
            dp[i][1] = Math.max(arr2[i], dp[i-1][1]+arr2[i]);
        }
        
        long max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++) {
            max = Math.max(Math.max(dp[i][0], dp[i][1]), max);
        }
        
        return max;
    }
}
