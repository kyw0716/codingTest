class Solution {
    public int solution(int n) {
        int answer = 0;
        String n_2 = Integer.toBinaryString(n).replace("0", "");
        for(int i=n+1;; i++) {
            String jinsu = Integer.toBinaryString(i).replace("0", "");
            if(jinsu.length() == n_2.length()) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}