class Solution {
    public String solution(int age) {
        String[] alp = {"a","b","c","d","e","f","g","h","i","j"};
        String[] answer = String.valueOf(age).split("");
        String real = "";
        for(int i = 0; i < answer.length; i++) {
            real += alp[Integer.parseInt(answer[i])];
        }
        return real;
    }
}