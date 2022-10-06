class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int result = n*m;
        if(n<m) {
            int temp = n;
            n = m;
            m = temp;
        }
        while(m!=0) {
            int r = n%m;
            n = m;
            m = r;
        }
        answer[0] = n;
        answer[1] = result/n;
        return answer;
    }
}