package sk000801.LEVEL3;
import java.util.*;
//22분
//같은 로직인데 왜 오름차순으로 비교할 때는 틀린걸꽈...
public class 숫자게임 {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idx = A.length-1;
        for(int i = A.length-1; i >= 0; i--) {
            if(A[i] < B[idx]) {
                answer++;
                idx--;
            } 
        }
        return answer;
    }
}
