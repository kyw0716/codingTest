class Solution {
    // 일단 문자열 길이만큼 for문을 돌려보자
    // 첫번째 문자와 비교하며 count를 해보자
    public int solution(String s) {
        int answer = 0;
        Character compare = s.charAt(0);
        int same = 1;
        int diff = 0;
        for (int i = 1; i < s.length(); i++) {
            if (same == diff) {
                answer++;
                compare = s.charAt(i);
                same = 0;
                diff = 0;
            } 
            if (s.charAt(i) == compare) {
                same++;
            } else {
                diff++;
            }
        }
        return answer+1;
    }
}