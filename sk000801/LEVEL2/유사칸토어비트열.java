package sk000801.LEVEL2;

//https://school.programmers.co.kr/learn/courses/30/lessons/148652
//56분동안 고민하고 힌트 보다가 결국 쉬운 풀이를 참조..
class 유사칸토어비트열 {
    public int solution(int n, long l, long r) {
        int answer = 0;

        for (long i = l-1; i < r; i++) {
            if (check(i)) answer++;
        }

        return answer;
    }

    boolean check(long l) {
        //하나라도 인덱스가 2라면 11011, 00000 모두 0 값을 가지기 때문에 계산하지 않는듯
        //첫번째 if문의 경우는 5보다 작은 자연 수 중 2가 아닌지
        if (l < 5 && l != 2) return true;
        //두번째 if문은 5로 나눴을 때의 값이 2인지(5개로 잘린 특정 부분에서의 인덱스가 2인지)
        if ((l - 2) % 5 == 0) return false;

        return check(l / 5);
    }
}