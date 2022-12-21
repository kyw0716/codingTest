import java.util.*;
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        int count = 0;
        String answer = "";
        for(int i = 0; i < db.length; i++) {
            if(id_pw[0].equals(db[i][0])) answer = id_pw[1].equals(db[i][1]) ? "login" : "wrong pw";
            else count++;
            
            if(answer.equals("login")) return answer;
            if(count == db.length) return "fail";
        }
        return "wrong pw";
    }
}