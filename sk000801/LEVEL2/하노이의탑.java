package sk000801.LEVEL2;

//30분이긴 한데 
//풀이 참고해서 코드 짜보고 답을 낸 시간일뿐,,
//재귀문제인것도 몰랐다 무슨 완전 탐색 문제인줄
//정말 리터럴하게(우리가 생각하는 그 순서대로) 재귀 코드를 짜는게 정답이었따
public class 하노이의탑 {
    static int idx = 0;
    public void jaegwi(int n, int start, int fin, int mid, int[][] answer) {
        if(n==1) answer[idx++] = new int[]{start, fin};
        else {
            //n-1개를 2번 원판으로 이동시킴
            jaegwi(n-1, start, mid, fin, answer);
            //마지막 링을 마지막 원판으로 바로 이동시킴
            answer[idx++] = new int[]{start, fin};
            //n-1개를 마지막 원판으로 이동시킴
            jaegwi(n-1, mid, fin, start, answer);
        }
    }
    public int[][] solution(int n) {
        int[][] answer = new int[(int)Math.pow(2, n)-1][2];
        jaegwi(n, 1, 3, 2, answer);
        return answer;
    }
}
