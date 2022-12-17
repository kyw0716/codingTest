class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] s = Integer.toString(n).split("");
        for(String ss : s) {
            answer += Integer.parseInt(ss);
        }
        return answer;
    }
}