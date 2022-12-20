class Solution {
    public int solution(int order) {
        String s = String.valueOf(order).replaceAll("[3 | 6 | 9]", "");
        return String.valueOf(order).length()-s.length();
    }
}