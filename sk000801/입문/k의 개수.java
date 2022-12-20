class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int p = i; p <= j; p++) {
            answer += String.valueOf(p).length()-String.valueOf(p).replaceAll(String.valueOf(k), "").length();
        }
        return answer;
    }
}