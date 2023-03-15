package sk000801.LEVEL2;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] min = new int[records.length];
        int[] num = new int[records.length];
        String[] inf = new String[records.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            String[] ss = s[0].split(":");
            min[i] = Integer.parseInt(ss[0])*60+Integer.parseInt(ss[1]);
            num[i] = Integer.parseInt(s[1]);
            if(!list.contains(num[i])) list.add(num[i]);
            inf[i] = s[2];
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        
        //23시 59분 = 1439분
        for(int i = 0; i < list.size(); i++) {
            int temp = 0;
            int count = 0;
            int count2 = 0;
            for(int j = 0; j < records.length; j++) {
                if(list.get(i) == num[j]) {
                    if(inf[j].equals("IN")) {temp -= min[j]; count++;}
                    else {temp += min[j]; count2++;}
                }
            }
            if(count != count2) temp += 1439;
            double money = (double)(temp-fees[0])/fees[2];
            
            //System.out.println(money);
            if(temp <= fees[0]) answer[i] = fees[1];
            else {
                if(money-(int)money == 0) answer[i] = fees[1]+(int)money*fees[3];
                else answer[i] = fees[1]+((int)money+1)*fees[3];
            }
        }
        return answer;
    }
}
