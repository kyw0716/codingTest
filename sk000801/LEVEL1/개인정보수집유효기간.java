package sk000801.LEVEL1;
// 41분 
// 이거 일케 오래 걸릴게 아닌데ㅠㅠ
// split에서 마침표는 [.]으로
// 파쇄해야 하는 정보를 정답 배열에 담는 건데 또 문제를 제대로 안읽음 ㅡㅡ
import java.util.*;
public class 개인정보수집유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> term = new HashMap<>();
        String[] cur = today.split("[.]");
        
        for(String s : terms) {
            String[] ss = s.split(" ");
            term.put(ss[0], Integer.parseInt(ss[1]));    
        } 
        
        for(int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            String[] days = info[0].split("[.]");
            int deadline = term.get(info[1]);
            int year = Integer.parseInt(days[0]);
            int month = Integer.parseInt(days[1])+deadline;
            int day = Integer.parseInt(days[2]);
            
            while(month > 12) {
                year++;
                month -= 12;
            }
            
            if(year < Integer.parseInt(cur[0])) {
                list.add(i+1);
                continue;
            } else if (year == Integer.parseInt(cur[0])) {
                if(month < Integer.parseInt(cur[1])) {
                    list.add(i+1);
                    continue;
                } else if(month == Integer.parseInt(cur[1])) {
                    if(day <= Integer.parseInt(cur[2])) {
                        list.add(i+1);
                        continue;
                    }
                }
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        Arrays.sort(ans);
       return ans;
    }
}
