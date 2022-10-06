class Solution {
    public String solution(String s) {
        String[] answer = s.split("");
        String real = "";   
        int count = 0;
        for(String ss : answer) {
            count = ss.contains(" ") ? 0 : count+1 ;
            real += count%2 == 0 ? ss.toLowerCase() : ss.toUpperCase();
        }
        return real;
    }
}
