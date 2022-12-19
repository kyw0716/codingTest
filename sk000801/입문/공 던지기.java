// k번째 2*(k-1)
class Solution {
    public int solution(int[] numbers, int k) {
        if(numbers.length > 2*(k-1)) return numbers[2*(k-1)];
        else {
            int[] many = new int[2*k];
            for(int i = 0; i < 2*k; i++) {
                many[i] = numbers[i%numbers.length];
            }
            return many[2*(k-1)];
        }
    }
}
