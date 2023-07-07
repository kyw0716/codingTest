package sk000801.LEVEL3;
import java.util.*;

//28분
//로직은 금방 구현했는데(비슷한 유형을 풀어봄)
//마지막에 시간초과가 걸리는 것이 amount가 0인데 계속 반복돼서..
public class 다단계칫솔판매 {
    Map<String, String> root = new HashMap<>(); //사람, 추천인
    Map<String, Integer> val = new HashMap<>(); //사람, 갖는 값
    public void addroot(String person, int amount) {
        if(amount == 0) return;
        if((int)(amount*0.1) < 1) val.put(person, val.get(person)+amount);
        else val.put(person, val.get(person)+amount-(int)(amount*0.1));

        if(root.containsKey(person)) addroot(root.get(person), (int)(amount*0.1));
    }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {        
        for(int i = 0; i < enroll.length; i++) {
            val.put(enroll[i], 0);
            if(referral[i].equals("-")) continue;
            root.put(enroll[i], referral[i]);
        }
        
        for(int i = 0; i < seller.length; i++) {
            addroot(seller[i], amount[i]*100);
        }
        
        int[] answer = new int[enroll.length];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = val.get(enroll[i]);
        }
        
        return answer;
    }
}
