package sk000801.LEVEL2;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/181188
//배열을 끝 점이 작은 순으로 정렬!
//그러고 이전 인덱스([a, b])까지 지나쳐온 값이 다음 시작 인덱스([c, d]) 이하(b <= c)라면
//설정한 구간을 다음 시작 인덱스의 끝(idx = d)으로 잡고 '정답 +1' 을 해준다
//25분
//백준에서 이전에 풀었던 문제와 비슷한듯 정렬하고 인덱스 값으로 비교하고,,,
class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(targets, new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        for(int i = 0; i < targets.length; i++) {
            if(idx <= targets[i][0]) {
                idx = targets[i][1];
                answer++;
            }
        }
        return answer;
    }
}
