class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String ss : s1) {
            for(String sss : s2) {
                if(ss.equals(sss)) answer++;
                continue;
            }
        }
        return answer;
    }
}