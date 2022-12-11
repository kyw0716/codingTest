class Solution {
    public int solution(String[] babbling) {
        String[] baleum = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String s : babbling) {
            String origin = s;
            for (String ss : baleum) {
                if (s.contains(ss)) {
                    s = s.replace(ss, " ");
                }
            }
            s = s.replaceAll(" ", "");
            if (s.equals("")) {
                answer++;
            }
        }
        return answer;
    }
}