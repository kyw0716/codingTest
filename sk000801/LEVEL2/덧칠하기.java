package sk000801.LEVEL2;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int temp = section[0]+m-1;
        for(int i = 0; i < section.length; i++) {
            if(temp >= section[i]) continue;
            else {
                answer++;
                temp = section[i]+m-1;
            }
        }
        return answer;
    }
}
