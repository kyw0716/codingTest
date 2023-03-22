package sk000801.LEVEL2;

//1,2,4라 3진법을 활용해서 계산해보는듯
//40분까지 풀어보다가 포오기이
//3진법이라는 힌트를 들어서 0, 1, 2 차례대로 1, 2, 4로 생각을 했다가
//다시 생각해보니 숫자 1부터 1, 2, 0 이런 순서대로 돌아가서 
//나머지로 정답에 들어갈 숫자를 구해주고 몫을 원래의 n값에 취해줬는데
//그러나 나머지가 0으로 나눠 떨어질때는 1을 빼줘야 함
//왜냐면 자리수가 바뀌는 부분이기 때문! (이 부분이 잘 이해가 안감 ㅠㅠ) 
//나머지 연산이므로 추가한 문자열을 뒤집어 출력해줘야함
class Solution {
    public String solution(int n) {    
        StringBuilder ans = new StringBuilder();
        while(n > 0){
            int nam = n%3;
            if(nam == 0) {
                n -= 1;
                ans.append("4");
            }
            if(nam == 1) {
                ans.append("1");
            }
            if(nam == 2) {
                ans.append("2");
            }
            n /= 3;
        }
      
        return ans.reverse().toString();
    }
}
