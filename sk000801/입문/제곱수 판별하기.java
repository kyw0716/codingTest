class Solution {
    public int solution(int n) {
        double num = (double) Math.sqrt(n);
        return num-Math.floor(num) == 0 ? 1 : 2;
    }
}