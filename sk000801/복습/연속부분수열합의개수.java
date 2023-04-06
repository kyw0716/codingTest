package sk000801.복습;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/131701
//이거 내가 아마 순열 방식으로 풀었을 때 틀렸던 거 같은데
//아 근데 이거 연속이다!! 바로 배열의 합을 구해도 돼
//풀이 방식을 생각하고 다시 푸니까 8분!!
public class 연속부분수열합의개수 {
    public static int solution(int[] elements) {
        int[] all = new int[elements.length*2];
        for(int i = 0; i < all.length; i++) {
            if(i < elements.length) all[i] = elements[i];
            else all[i] = elements[i-elements.length];
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= elements.length; i++) {
            for(int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(all, j, j+i).sum());
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }
}
