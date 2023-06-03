package sk000801.복습;
import java.util.*;

//20분
//2,3,4를 읽고 일단 정렬해야겠다는 생각 먼저 한 건 good
//but HashMap을 바로 떠올리지 못함,,
public class 시소짝꿍 {
    public static long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for(int i = 0; i < weights.length; i++) {
            double a = weights[i]*1.0;
            double b = weights[i]*0.5;
            double c = weights[i]*2.0/3.0;
            double d = weights[i]*3.0/4.0;
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            map.put(1.0*weights[i], map.getOrDefault(1.0*weights[i], 0)+1);
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] weights = {100,180,360,100,270};
        System.out.println(solution(weights));
    }
}
