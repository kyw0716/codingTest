class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        if(num%2==1) {
            for(int i = -num/2; i <= num/2; i++) {
                answer[num/2+i] = total/num+i;
            }
        } else {
            for(int i = 0; i < num; i++) {
                answer[i] = total/num-(num/2-1)+i;
            }
        }
        return answer;
    }
}