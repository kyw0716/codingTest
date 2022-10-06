class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean front = true;
        for(char c : s.toCharArray()) {
            sb.append(front? Character.toUpperCase(c) : Character.toLowerCase(c));
            front = (c == ' ') ? true : false;    
        }
        return sb.toString();
    }
}