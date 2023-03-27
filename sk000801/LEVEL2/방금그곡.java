package sk000801.LEVEL2;
import java.util.*;

//일단은 #이 들어간 친구들을 미리 다른 숫자로 바꿔줘야함
//28번에서 자꾸 문제가 났는데 HashMap은 순서 보장이 안돼 LinkedHashMap을 사용해줘야 했기 때문!!!
//간단한 건 잘되는데 아마도 테케는 긴 map을 사용해서 그런 거 같다
//44분....
class Solution {
    public String[] set = {"A#", "C#", "D#", "F#", "G#"};
    public String[] change = {"a", "c", "d", "f", "g"};
    public String solution(String m, String[] musicinfos) {
        for(int i = 0; i < 5; i++) {
            m = m.replaceAll(set[i], change[i]);
        }
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < musicinfos.length; j++) {
                musicinfos[j] = musicinfos[j].replaceAll(set[i], change[i]);
            }
        }
        LinkedHashMap<String, Integer> ans = new LinkedHashMap<>();
        for(int i = 0; i < musicinfos.length; i++) {
            String[] info = musicinfos[i].split(",");
            int s1 = Integer.parseInt(info[0].split(":")[0]);
            int f1 = Integer.parseInt(info[0].split(":")[1]);
            int s2 = Integer.parseInt(info[1].split(":")[0]);
            int f2 = Integer.parseInt(info[1].split(":")[1]);
            int time = 60*(s2-s1)+f2-f1;
            if(time == 0) time++;            
            String name = info[2];
            String eum = info[3];
            String eumall = "";
            for(int j = 0; j < time; j++) {
                eumall += Character.toString(eum.charAt(j%eum.length()));
            }
            if(eumall.contains(m)) ans.put(name, time);
        }
        if(ans.isEmpty()) return "(None)";
        List<Integer> times =  new ArrayList<>(ans.values());
        Collections.sort(times, Comparator.reverseOrder());
        
        String answer = "";
        for(String s : ans.keySet()) {
            if(ans.get(s) == times.get(0)) {
                answer = s;
                break;
            }
        }
        return answer;
    }
}
