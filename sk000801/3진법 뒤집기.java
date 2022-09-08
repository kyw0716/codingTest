package sk000801;

class Solution {
    public int solution(int n) {
        String a = Integer.toString(n,3);
        String reversed = new StringBuffer(a).reverse().toString();
        int answer = Integer.parseInt(reversed,3);
        return answer;
    }
}
