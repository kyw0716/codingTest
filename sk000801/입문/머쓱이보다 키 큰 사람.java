<<<<<<< Updated upstream
class Solution {
    public int solution(int[] array, int height) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > height) {
                count++;
            }
        }
        return count;
    }
=======
class Solution {
    public int solution(int[] array, int height) {
        int count = 0;
        for(int i = 0; i < array.length; i++) {
            if(array[i] > height) {
                count++;
            }
        }
        return count;
    }
>>>>>>> Stashed changes
}