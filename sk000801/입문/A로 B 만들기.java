import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String[] b = before.split("");
        Arrays.sort(b);
        String[] a = after.split("");
        Arrays.sort(a);
        return Arrays.equals(a,b) ? 1 : 0;
    }
}