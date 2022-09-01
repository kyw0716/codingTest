package sk000801;
import java.util.*;
import java.lang.*;

class Solution {
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<survey.length; i++) {
            if(choices[i]<=3) {
                Character c = survey[i].charAt(0);
                String a = c.toString();
                if(map.containsKey(a)) {
                    if(choices[i]==1) {
                        map.replace(a, map.get(a)+3);
                    }
                    if(choices[i]==2) {
                        map.replace(a, map.get(a)+2);
                    }
                    if(choices[i]==3) {
                        map.replace(a,map.get(a)+1);
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
                Character b2 = survey[i].charAt(1);
                String b = b2.toString();
                if(map.containsKey(b)) {
                    if(choices[i]==5) {
                        map.replace(b, map.get(b)+1);
                    }
                    if(choices[i]==6) {
                        map.replace(b, map.get(b)+2);
                    }
                    if(choices[i]==7) {
                        map.replace(b, map.get(b)+3);
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
        String[] set1 = {"R", "T", "C", "F", "J", "M", "A", "N"};
        for(int j=0; j<set1.length; j++) {
            if(!map.containsKey(set1[j])) map.put(set1[j], 0); 
        }

        if((map.get("R"))>=map.get("T")) answer += "R";
        else {answer += "T";}
        if(map.get("C")>=map.get("F")) answer += "C";
        else {answer += "F";}
        if(map.get("J")>=map.get("M")) answer += "J";
        else {answer += "M";}
        if(map.get("A")>=map.get("N")) answer += "A";
        else {answer += "N";}
        
        System.out.println(map.get("R"));
        
        return answer;
    }

    public static void main(String[] args) {
        String sol1[] = {"AN", "CF", "MJ", "RT", "NA"};
        int sol2[] = {5, 3, 2, 7, 5};

        solution(sol1 , sol2);
    }
}    

