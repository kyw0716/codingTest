class Solution {
    public String solution(String s) {
        String[] string  = s.split(" ");
        int[] string2 = new int[string.length];
        for(int i=0; i<string.length; i++) {
            string2[i] = Integer.parseInt(string[i]);
        }
        int max = string2[0];
        int min = string2[0];
        for(int i=1; i<string2.length; i++) {
            max = Math.max(max, string2[i]);
            min = Math.min(min, string2[i]);
        }
        String answer = Integer.toString(min) + " " + Integer.toString(max);
        return answer;
    }
}