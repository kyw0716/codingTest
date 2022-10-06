

class Solution33 {
    boolean solution(String s) {
        boolean answer = true;
        s = s.toLowerCase();
        System.out.println(s);
        long p = s.chars().filter(c -> c == 'p').count();
        long y = s.chars().filter(c -> c == 'y').count();
        if(p != y) {
            answer = false;
        }
        return answer;
    }
}