class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String num = my_string.replaceAll("[^0-9]", " ");
        String[] list = num.split(" ");
        for(String s : list) {
            if(!s.replaceAll(" ", "").equals("")) answer += Integer.parseInt(s);
        }
        return answer;
    }
}