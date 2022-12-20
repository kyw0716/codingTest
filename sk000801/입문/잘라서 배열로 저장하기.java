class Solution {
    public String[] solution(String my_str, int n) {
        return my_str.split("(?<=\\G.{" + n + "})");
    }
}