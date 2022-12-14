import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        int hap = 0;
        for(int i = 0; i < numbers.length; i++) {
            hap += numbers[i];
        }
        return (double)hap/numbers.length;
    }
}