package sk000801.LEVEL2;
import java.util.*;

//45분
//문제에 주어진 경우만 고려했다
//입출력 예에서 2/4, 2/3, 3/4의 경우만 !!
//정렬을 해주면 이 값이 뒤바뀌는 경우는 고려하지 않아도 괜찮다
//https://school.programmers.co.kr/learn/courses/30/lessons/152996
public class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>(); 
        for(int i : weights) {
            double a = i*1.0;
            double b = (i*2.0)/3.0;
            double c = (i*1.0)/2.0;
            double d = (i*3.0)/4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put((double)i*1.0, map.getOrDefault(i*1.0, 0)+1);
        }
        return answer;
    }
}

//dp로 풀다 망...
// Set<Integer> set = new HashSet<>();
//         for(int i = 0; i < weights.length; i++) {
//             set.add(weights[i]);
//         }
//         List<Integer> list = new ArrayList<>(set);
        
//         int diff = weights.length-list.size();
        
//         long answer = 0;
//         long[] dp = new long[4001]; //나올 수 있는 무게,,?
//         for(int i = 0; i < list.size(); i++) {
//             dp[list.get(i)*2]++;
//             dp[list.get(i)*3]++;
//             dp[list.get(i)*4]++;
//         }
//         for(int i = 0; i < dp.length; i++) {
//             if(dp[i]>1) {
//                 answer += (dp[i]*(dp[i]-1))/(long)2;
//             }
//         }

//         return answer+diff;
