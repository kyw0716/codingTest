import java.util.*;
class Solution {
    public int solution(int[] array) {
        String arr = Arrays.toString(array);
        arr = arr.substring(1, arr.length()-1).replaceAll("[, ]", "");
        return arr.length()-arr.replaceAll("[7]", "").length();
        }
}