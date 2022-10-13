import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int count = 0;
        int min = 0;
        for(int max=people.length-1; max >= min; max--) {
            if(people[min]+people[max]<=limit) {
                min++;
            }
            count++;
        }

        return count;
    }
}