package sk000801.LEVEL3;
import java.util.*;
//https://junboom.tistory.com/24 풀이 참조..
//https://school.programmers.co.kr/learn/courses/30/lessons/42627
//70분..
public class 디스크컨트롤러 {
    //시간이 덜 걸리는 디스크가 먼저 실행되어야 하나,
    //만약 둘 사이에 공백이 생겨 컨트롤러가 쉬게끔 하면 안되기 때문에
    //우선순위 큐에는 걸리는 시간이 작은 디스크의 우선순위를 높이되
    //주어진 배열을 큐에 넣을 때는 대기 시점이 작은 인덱스부터 차례대로 들어가게끔 함(어차피 그 중 걸리는 시간이 작은 애가 알아서 들어감)
    public int solution(int[][] jobs) { 
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
           @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        
        int idx = 0;
        int start = 0;
        while(idx < jobs.length || !pq.isEmpty()) {
            while(idx < jobs.length && start >= jobs[idx][0]) {
                pq.add(jobs[idx++]);
            }
            
            //만약 중간에 공백이 생기거나 jobs 배열의 모든 값들을 큐에 넣었을 때
            if(!pq.isEmpty()) { //이미 값이 존재한다면 처리
                int[] cur = pq.poll();
                start += cur[1];
                answer += start-cur[0];
            } else { //아니라면 현재 인덱스의 대기값을 시작 값으로 설정! (아마도 가장 처음이지 않을까,,)
                start = jobs[idx][0];
            }
        }
        
        return answer/jobs.length;
    }
}

// 가장 처음 잘못했던 풀이다.. 
// 아무 생각없이 처리가 덜 걸리는 디스크가 먼저 이동하도록 함
// 이렇게 하면 중간에 공백이 생겨서 문제가 발생
// Arrays.sort(jobs, new Comparator<int[]>() {
//             @Override
//             public int compare(int[] a, int[] b) {
//                if(a[1] == b[1]) return a[0]-b[0];
//                return a[1]-b[1];
//             }
//         });
//         int cur = jobs[0][0];
//         int answer = 0;
//         for(int i = 0; i < jobs.length; i++) {
//             cur += jobs[i][1];
//             answer += (cur-jobs[i][0]);
//         }
//         return answer/jobs.length;
