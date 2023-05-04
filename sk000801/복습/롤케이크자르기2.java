package sk000801.복습;
import java.util.*;

//10분
//리스트랑 set으로 시간 복잡도 n을 맞추려고 아무리 용을 써봐도 안됨
//그냥 HashMap으로 시간을 절약하는 것이 좋음,,,
public class 롤케이크자르기2 {
    public static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> all = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < topping.length; i++) {
            all.put(topping[i], all.getOrDefault(topping[i], 0)+1);
        }

        for(int i = 0; i < topping.length; i++) {
            all.put(topping[i], all.get(topping[i])-1);
            if(all.get(topping[i]) == 0) all.remove(topping[i]);
            set.add(topping[i]);
            if(all.size() == set.size()) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1,2,3,1,4};
        System.out.println(solution(topping));
    }
}
