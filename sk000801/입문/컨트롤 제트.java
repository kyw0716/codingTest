class Solution {
    public int solution(String s) {
        String[] s1 = s.split(" ");
        int answer = 0;
        for(int i = 0; i < s1.length; i++) {
            if(s1[i].equals("Z")) answer -= Integer.parseInt(s1[i-1]);
            else answer += Integer.parseInt(s1[i]);
        }
        return answer;
    }
}