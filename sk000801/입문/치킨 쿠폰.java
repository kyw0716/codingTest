// 틀린 풀이
// 108 + 10 + 1 
class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int nameogi = 0;
        int chi = 0;
        while (chicken/10 > 0) {
            if(chicken/10 >= 1) {
                chi = chicken/10;  //108 -> 10 -> 1
                chicken = chi;
                answer += chi;
            }
            nameogi += chicken%10;  //1 -> 9 -> 9
            if(nameogi >= 10) {
                answer += nameogi%10;
                nameogi %= 10;
            }
        }
        return answer;
    }
}


//맞은 풀이
// 108 + 10 + 1 
class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken/10 > 0) {
            int chi = chicken/10;
            chicken = chi+chicken%10;
            answer += chi;
        }
        return answer;
    }
}