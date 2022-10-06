class Solution {
    public int solution(int[] a, int[] b) {
        int answer=0;
        for(int i=0; i<a.length; i++) {
            answer += a[i]*b[i];
        }
        return answer;
    }
}

//다른 사람 한줄에 끝냄...
//return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();