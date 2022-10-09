class Solution {
    public int[] solution(int brown, int yellow) {
        int all = brown+yellow;
        int[] answer = new int[2];
        for(int i=1; i<all/2; i++) {
            if(all%i==0) {
                if((all/i+i)*2-4 == brown) {
                    answer[0] = i; answer[1] = all/i;
                }
            }
        }
        return answer;
    }
}