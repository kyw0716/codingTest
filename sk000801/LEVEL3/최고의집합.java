package sk000801.LEVEL3;
import java.util.*;
//힌트 보고 14분
//n=2로 주어진 예시 보고 생각은 했다 무조건 중간값? s를 2로 나눈 값이 무조건 들어가는데
//이거를 어떻게 전체 n에 적용할까 싶었는데 값이 하나씩 채워질때마다
//n의 값을 하나씩 줄이고 s의 값을 해당 값만큼 빼줘서 나누면 되는구나...
class Solution {
    public int[] solution(int n, int s) {
        if(s==1 || n > s) return new int[]{-1};
        
        int[] answer = new int[n];
        
        int idx = 0;
        
        while(n>0) {
            answer[idx++] = s/n;
            n--;
            s -= answer[idx-1];
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
}
