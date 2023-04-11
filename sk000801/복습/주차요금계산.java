package sk000801.복습;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/92341
public class 주차요금계산 {
    //fees[0]: 기본시간 fees[1]: 기본요금 fees[2]: 단위시간 fees[3]: 단위요금
    public static int[] solution(int[] fees, String[] records) {
        int[] val = new int[records.length];
        int[] nums = new int[records.length];
        List<Integer> num = new ArrayList<>();
        String[] enter = new String[records.length];

        for(int i = 0; i < records.length; i++) {
            String[] s = records[i].split(" ");
            String[] time = s[0].split(":");
            val[i] = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            enter[i] = s[2];
            nums[i] = Integer.parseInt(s[1]);
            if(!num.contains(Integer.parseInt(s[1]))) num.add(Integer.parseInt(s[1])); 
        }
        Collections.sort(num);

        int[] ans = new int[num.size()];

        for(int i = 0; i < num.size(); i++) {
            int temp = 0;
            int count1 = 0;
            int count2 = 0;
            int n = num.get(i);
            for(int j = 0; j < records.length; j++) {
                if(n == nums[j]) {
                    if(enter[j].equals("IN")) {temp -= val[j]; count1++;}
                    else {temp += val[j]; count2++;}
                }
            }
            if(count1 != count2) temp += 1439;
            ans[i] = temp;
        }
        //42분까지... 이 바보.. 

        //소수점 맞추기
        //5분?? casting할 때 꼭 (double) 붙여줘야됨 안그러면 적용 안돼
        for(int i = 0; i < ans.length; i++) {
            if(ans[i] <= fees[0]) ans[i] = fees[1];
            else {
                double money = (double) (ans[i]-fees[0])/fees[2];
                if((int)money-money == 0) ans[i] = fees[1]+(int)money*fees[3];
                else ans[i] = fees[1]+((int)money+1)*fees[3];
            }   
        }

        return ans;
    }
    public static void main(String[] args) {
        // int[] fees = {180, 5000, 10, 600};
        // String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        
        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        // int[] fees2 = {1,461,1,10};
        // String[] records2 = {"00:00 1234 IN"};
        int[] ans = solution(fees, records);

        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
