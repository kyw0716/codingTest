package sk000801.LEVEL2;

//38분
//아니 왜 효율성은 안맞춰질까ㅡㅡ
//소수라면 1을, 값이 1이라면 0을, 나머지는 약수 중 가장 큰 수(본인 제외)를 구하도록
//소수를 판별하는 알고리즘(에라토스테네스의 체?)을 활용했는데
//효율성에서 자꾸 걸려서 풀이를 참조했고

//풀이는 리스트를 활용해 가능한 값들을 모두 담고 그 마지막 값을 return해준다
//(왜냐면 for문이 가장 작은 수부터 시작되기 때문에,, 마지막 값이 가장 큼) 
//이때 원래 수에서 이 가능한 수를 나눈 수가 정해진 범위에 들어와 있으면 무조건 최댓값이므로
//그 값을 정답으로!
import java.util.*;
class 숫자블록 {
    public long getBig(long num) {
        List<Integer> list = new ArrayList<>();
        if(num == 1) return 0;
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num%i==0) {
                list.add(i);
                if(num/i <= 10_000_000) return num/i;
            }
        }
        if(!list.isEmpty()) return list.get(list.size()-1);
        return 1;
    }
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin)+1];
        for(long l = begin; l <= end; l++) {
            answer[(int)(l-begin)] = (int) getBig(l);
        }
        return answer;
    }
}
