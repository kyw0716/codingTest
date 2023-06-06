package sk000801.복습;
import java.util.*;

//12분..?
public class 숫자블록 {
    public static long getNum(long l) {
        List<Integer> list = new ArrayList<>();
        if(l == 1) return 0;
        //에라토스테네스의 체
        for(int i = 2; i <= Math.sqrt(l); i++) {
            if(l%i == 0) {
                list.add(i);
                //(제일 작은 소수로 나눈 몫이 블록의 색깔)
                //가장 큰 수 return , 여기서 return 받으면 i가 가장 작은 수기 때문에
                if(l / i <= 10_000_000) return l/i;
            }
        }
        //이건 이제 리스트 안의 i값들 중 가장 큰거 return
        if(!list.isEmpty()) return list.get(list.size()-1);
        return 1;
    }
    public static int[] solution(long begin, long end) {
        int[] ans = new int[(int)(end-begin)+1];
        for(long l = begin; l <= end; l++) {
            ans[(int)(l-begin)] = (int) getNum(l);
        }
        return ans;
    }
    public static void main(String[] args) {
        long begin = 1; long end = 10;
        int[] ans = solution(begin, end);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
