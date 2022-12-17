class Solution {
    public String solution(String my_string) {
        String s = "";
        for(int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if(Character.isUpperCase(c)) s += Character.toString(Character.toLowerCase(c));
            else s += Character.toString(Character.toUpperCase(c));
        }
        return s;
    }
}