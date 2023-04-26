package sk000801.복습;
import java.util.*;

//15분
//내가 풀 수 있는 방법으로 for문을 돌려 풀었다(어차피 10^3이라 시간 복잡도에 걸리지도 않음)
public class 연속부분수열합의개수2 {
    public static int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int[] element = new int[elements.length*2];
        for(int i = 0; i < element.length; i++) {
            if(i < elements.length) element[i] = elements[i];
            else element[i] = elements[i-elements.length]; 
        }
        for(int i = 1; i <= elements.length; i++) { //연속부분수열
            for(int j = 0; j < elements.length; j++) {
                int answer = 0;
                for(int r = j; r < j+i; r++) {
                    answer += element[r];
                }
                set.add(answer);
            }
        }
        return set.size();
    }
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }
}
