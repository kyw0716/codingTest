class Solution {
    public int solution(int hp) {
        int answer = 0;
        answer += hp/5;
        hp %= 5;
        if(hp <= 0) return answer;
        answer += hp/3;
        hp %= 3;
        if(hp <= 0) return answer;
        answer += hp;
        return answer;
    }
}