// 일단 약수를 구한다
// 약수들 중 소인만 걸러 
// -> 걸러진 약수들을 그 아래 숫자들로 for문으로 나눠
//  나눠질 때 count를 1 더해주는데 그 count값이 1인 약수만 정답에 담아줌
import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> yaksu = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if (i*i == n) yaksu.add(i);
            else if (n%i == 0) {yaksu.add(i); yaksu.add(n/i);}
        }
        for(int i = 0; i < yaksu.size(); i++) {
            int count = 0;
            for(int j = 2; j <= yaksu.get(i); j++) {
                if(yaksu.get(i)%j==0) count++;
            }
            if(count == 1) answer.add(yaksu.get(i));
        }
        int[] ans = new int[answer.size()];
        for(int i =0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}