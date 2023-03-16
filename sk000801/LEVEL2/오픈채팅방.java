package sk000801.LEVEL2;
import java.util.*;

public class Solution {
    public static String[] solution(String[] record) {              
        HashMap<String, String> map = new HashMap<String, String>();
        int count = 0;
        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Leave")) continue;           
            else if(s[0].equals("Change")) count++;
            map.put(s[1], s[2]);
        }

        String[] result = new String[record.length - count];
        int index = 0;

        for(int i=0; i<record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                result[index] = map.get(s[1]) + "님이 들어왔습니다.";
                index++;
            }else if(s[0].equals("Leave")) {
                result[index] = map.get(s[1]) + "님이 나갔습니다.";
                index++;
            }
        }        

        return result;
    }
}
