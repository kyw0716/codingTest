class Solution {
    public int choiso(int num1, int num2) {
        int choiso = 1;
        for(int i = 1; i <= Math.min(num1, num2); i++) {
            if(num1 % i == 0 && num2 % i == 0) {
                choiso = i;
            }
        }
        return choiso;
    }
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = {denum1*num2+denum2*num1, num1*num2};
        int choidae = choiso(answer[0], answer[1]);
        answer[1] /= choidae;
        answer[0] /= choidae;
        return answer;
    }
}