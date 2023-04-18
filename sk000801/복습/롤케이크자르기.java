package sk000801.복습;
import java.util.*;

// #1방식: 배열을 나눠 set으로 바꾸는 것부터 2중 for문이라 시간 초과날 것 같긴 함
// #2방식: 전체 리스트와 리스트의 인덱스 0값을 삭제하고 새로운 set에 넣어주어 두 size를 비교
//40분 잡아먹은듯..
public class 롤케이크자르기 {
    public static int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> all = new HashMap<>();
        Set<Integer> bro = new HashSet<>();
        bro.add(topping[0]);
        
        for(int i = 1; i < topping.length; i++) {
            all.put(topping[i], all.getOrDefault(topping[i], 0)+1);
        }

        for(int i = 1; i < topping.length; i++) {
            bro.add(topping[i]);
            all.put(topping[i], all.get(topping[i])-1);
            if(all.get(topping[i]) == 0) all.remove(topping[i]);
            if(all.size() == bro.size()) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};
        System.out.println(solution(topping1));
        System.out.println(solution(topping2));
    }
}
