class Solution {
    public int solution(int num, int k) {
       String num1 = String.valueOf(num);
       return num1.indexOf(String.valueOf(k))== -1 ? -1 : num1.indexOf(String.valueOf(k))+1;
    }
}