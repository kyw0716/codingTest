package sk000801.복습;
import java.util.*;

//21분!!! 이번에는 원래랑 다르게 hashmap을 한개 더 써서 생각하는데 시간이 걸린 거 같기도...
public class 할인행사 {
    public static boolean check(String[] want, HashMap<String, Integer> map, HashMap<String, Integer> map2) {
        for(int i = 0; i < want.length; i++) {
            if(map.get(want[i]) != map2.get(want[i])) return false;
        }
        return true;
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for(int i = 0; i <= discount.length-10; i++) {
            HashMap<String, Integer> map2 = new HashMap<>();
            boolean all = false;
            for(int j = i; j < i+10; j++) {
                if(!map.keySet().contains(discount[i])) break;
                map2.put(discount[j], map2.getOrDefault(discount[j], 0)+1);
                if(j==i+9) all = true;
            }
            if(all && check(want, map, map2)) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        int a =  solution(want, number, discount);
        System.out.println(a);
    }
}
