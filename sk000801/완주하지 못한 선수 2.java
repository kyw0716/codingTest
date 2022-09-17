import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> list = new HashMap<String, Integer>();
        for(int i=0; i<participant.length; i++) {
            if(list.containsKey(participant[i])) {list.put(participant[i], list.get(participant[i])+1);}
            else list.put(participant[i], 1);
        }

        for(int i=0; i<completion.length; i++) {
            if(list.containsKey(completion[i])) list.put(completion[i], list.get(completion[i])-1); 
        } 

        for(String key : list.keySet()) {
            if(list.get(key).equals(1)) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
