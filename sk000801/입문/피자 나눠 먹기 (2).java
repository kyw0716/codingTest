class Solution {
    public int solution(int n) {
        int count = 1;
        while(6*count%n != 0) {
            count++;
        }
        return count;
    }
}