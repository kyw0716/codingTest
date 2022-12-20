import java.util.*;
class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] le = letter.split(" ");
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] al = { "a", "b","c","d","e","f", "g","h","i","j","k","l",
            "m","n","o","p","q","r", "s","t","u","v","w","x", "y","z" };
        for(int i = 0; i < le.length; i++) {
            answer += al[Arrays.asList(morse).indexOf(le[i])];
        }
        return answer;
    } 
}