import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> p = Arrays.asList(participant);
        List<String> c = Arrays.asList(completion);

        for(int i=0; i<participant.length; i++) {
            if(!c.contains(participant[i])) {
                answer = participant[i];
            }
            else if(Collections.frequency(c, participant[i])
                    < Collections.frequency(p,participant[i]))  {
                    answer = participant[i];
                }
            }
        return answer;
    }
}