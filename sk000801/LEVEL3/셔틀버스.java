package sk000801.LEVEL3;
import java.util.*;

//57분,, 풀던대로 풀면 되는데 아닌 거 같다구 혼자 쌩쇼해서 시간 더 걸린듯함
public class 셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(String s : timetable) {
            String[] arr = s.split(":");
            list.add(Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]));
        }
        Collections.sort(list);
        
        int start = 540;
        int fin = 0;
        int idx = 0;
        int count = 0;
        for(int i = 0; i < n; i++) { //총 n회라는게 다 합쳐서 n번 버스가 온다는 거였다능 ㅋ
            count = 0;
            if(idx >= list.size()) break;
            while(count < m) {
                if(idx >= list.size()) break;
                if(start >= list.get(idx)) {
                    fin = list.get(idx);
                    count++;
                    idx++;
                } else break;
            }
            start += t;
        }
        
        if(count < m) { //마지막 버스에 자리가 있음
            answer += String.format("%02d", (start-t)/60)+":"+String.format("%02d", (start-t)%60);
        } else { //마지막 사람보다 1분 빨리 와야됨
            answer += String.format("%02d", (fin-1)/60)+":"+String.format("%02d", (fin-1)%60);
        }
        return answer;
    }
}
