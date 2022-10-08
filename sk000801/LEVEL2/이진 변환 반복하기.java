class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String s2 = s;
        while(!s2.equals("1")) {
            String s1 = s2.replace("0", "");
            answer[1] += s2.length()-s1.length();
            s2 = Integer.toBinaryString(s1.length());
            answer[0]++;
        }
        return answer;
    }
}