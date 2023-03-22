package sk000801.LEVEL2;

//접근을 하지 못함 => 주제가 '그리디' 였던 것에 더 집중했어야 함
// 0~끝부터 k만큼 앞 인덱스까지 중 가장 큰 숫자를 고른다
// 가장 큰 숫자를 버퍼에 삽입하고, 그 인덱스+1 을 시작숫자로 잡고 
// 그 사이의 값 중 가장 큰 값을 고른다
// 위의 과정을 반복한다
class Solution {
    public String solution(String number, int k) {
        StringBuilder ans = new StringBuilder("");
        int start = 0;
        int next = 0;
        
        for(int i = 0; i < number.length()-k; i++) {
            int max = 0;
            for(int j = start; j <= i+k; j++) {
                int cur = number.charAt(j)-'0'; 
                
                if(max < cur) {
                    max = cur;
                    next = j;
                }
            }
            ans.append(max);
            start = next+1;
        }

        return ans.toString();
    }
}
