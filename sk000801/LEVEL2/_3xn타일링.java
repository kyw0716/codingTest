package sk000801.LEVEL2;

//왜 아래가 안될까,,,,
//https://school.programmers.co.kr/learn/courses/30/lessons/12902
//내가 생각했던 점화식은 dp[i] = dp[i-2]*4-dp[i-4]인데 왠지 모르게 mod로 나눴을 때 음수가 될 것을 고려하여 mod값을 한번 더 더했는데도 안돼서ㅠㅠ
//이 방식은 하향식 방법으로 모듈러를 분배시켜 연산을 해줘야 한다.
//근데 블로그 찾아보니 내가 원래 작성했던 코드도 잘 돌아갔어야 함.. 그럼 왜?
//dp[i] = dp[i-2]*3+2*(dp[i-4]~짝수인덱스의 합) 으로 점화식만 바꾸니까 바로 정답이 되었다..
//레전드 DP문제...
class _3xn타일링 {
    public int solution(int n) {
        if(n%2==1) return 0;
        
        long[] dp = new long[n+1];
        dp[0] = 1; dp[2] = 3; 
        long mod = 1_000_000_007;
        
        if(n < 4) return (int) dp[n];
        for(int i = 4; i <= n; i+=2) {
            dp[i] = dp[i-2]*3; //dp[i-2]*dp[2]
            for(int j = i-4; j >= 0; j-=2) {
                dp[i] += 2*dp[j];
            }
            dp[i] %= mod;
        }
        
        return (int) dp[n];
    }
}
