
class Solution {
    int answer = 0;
    public int solution(String s) {  
        String number = "[0-9]+";
        String[] str = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        //문자열이다숫자라면
        if(s.matches(number)) {
            answer = Integer.parseInt(s);
        }
        else {
            for(int i=0; i<str.length; i++) {
                s = s.replace(str[i], Integer.toString(i));
            }
            answer = Integer.parseInt(s);
        }
        return answer;
    }
}