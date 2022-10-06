import java.util.Arrays;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] sort = new String[strings.length];
        for(int i=0; i<strings.length; i++) {
            sort[i] = "" + String.valueOf(strings[i].charAt(n)) + strings[i];
        }
        Arrays.sort(sort);
        for(int i=0; i<strings.length; i++) {
            sort[i] = sort[i].substring(1);
        }
        return sort;
    }
}