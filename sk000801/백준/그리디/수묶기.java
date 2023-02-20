package sk000801.백준.그리디;
import java.util.*;

//경우가 너무 많을 거 같다
//다 음수라던지, 0과1이 모두 껴있다던지....
//그래서 말 그대로 양수와 0+음수로 구분하였다
//양수는 높은 숫자 두개씩 묶어 계산하고
//음수도 제일 작은 숫자부터 두개씩 묶어 계산한다
//남는 수는 그냥 더해준다
public class 수묶기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int nn = in.nextInt();
        List<Integer> big = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        int answer = 0;

        for(int i = 0; i < nn; i++) {
            int a = in.nextInt();
            if(a>0) big.add(a);
            else small.add(a);
        }
        big.sort(Comparator.reverseOrder());
        small.sort(Comparator.naturalOrder());
        
        int n = 0;
        while(n <= big.size()-1) {
            if(n+1 < big.size() && big.get(n) != 1 && big.get(n+1) != 1) answer += big.get(n++)*big.get(n++);
            else answer += big.get(n++);
        }      

        int i = 0;
        while(i <= small.size()-1) {
            if(i+1 < small.size()) answer += small.get(i++)*small.get(i++);
            else answer += small.get(i++);
        }    

        System.out.println(answer);
    }
}
