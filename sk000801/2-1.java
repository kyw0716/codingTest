package sk000801;
import java.util.*;

class solution {

    public String solution(String[] survey, int[] choices) {

        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            if(choices[i]<=3) {
                Character a = survey[i].charAt(0);
                if(map.containsKey(a)) {
                    if(choices[i]==1) {
                        map.put(a, map.get(a)+3);
                    }
                    if(choices[i]==2) {
                        map.put(a, map.get(a)+2);
                    }
                    if(choices[i]==3) {
                        map.put(a,map.get(a)+1);
                    }
                }
                else {
                    if(choices[i]==1) {
                        map.put(a, 3);
                    }
                    if(choices[i]==2) {
                        map.put(a, 2);
                    }
                    if(choices[i]==3) {
                        map.put(a,1);
                    }
                }

            }
            if(choices[i]>=5) {
                Character b = survey[i].charAt(1);
                if(map.containsKey(b)) {
                    if(choices[i]==5) {
                        map.put(b, map.get(b)+1);
                    }
                    if(choices[i]==6) {
                        map.put(b, map.get(b)+2);
                    }
                    if(choices[i]==7) {
                        map.put(b, map.get(b)+3);
                    }
                }
                else {
                    if(choices[i]==5) {
                        map.put(b, 1);
                    }
                    if(choices[i]==6) {
                        map.put(b, 2);
                    }
                    if(choices[i]==7) {
                        map.put(b,3);
                    }
                }  
            }
        }
        if(map.get('R')>=map.get('T')) answer += "R";
        else {answer += "T";}
        if(map.get('C')>=map.get('F')) answer += "C";
        else {answer += "F";}
        if(map.get('J')>=map.get('M')) answer += "J";
        else {answer += "M";}
        if(map.get('A')>=map.get('N')) answer += "A";
        else {answer += "N";}
        
        return answer;
    }
}
