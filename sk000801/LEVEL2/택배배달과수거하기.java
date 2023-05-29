package sk000801.LEVEL2;

public class 택배배달과수거하기 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/150369
    //모르기 때문에 시간을 잴 이유가 없음..
    //https://school.programmers.co.kr/questions/43364 설명 참조

    //내가 생각해야 할 기준
    // 한 번 출발해서, 물류창고로 돌아오는 왕복 거리 동안 최대 cap만큼 배달, 수거도 할 수 있음
    // 배달할 물건, 회수할 물건이 어떤 인덱스에 존재한다면 무조건 그 인덱스까지는 가야 함
    // 배달 or 회수를 한번에 하지 못한다면 다시 방문해야함
    // 이때 거꾸로 배열을 탐색 = 방문이 가능한 모든 지점들을 왕복
    // 거꾸로 배열을 탐색할 생각도, 값이 모자라면 채운 뒤 횟수를 증가시킬 생각도 어려웠다
    // n만 작았으면 단지 백트래킹을 통해 모든 경우의 수에서 최솟값을 구해보려 했던 자신....
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long d = 0; 
        long p = 0;
        for(int i = n-1; i >= 0; i -= 1) {
            int count = 0;
            d -= deliveries[i];
            p -= pickups[i];
            
            while(d < 0 || p < 0) {
                d += cap;
                p += cap;
                count++;
            }
            
            answer += (i+1)*2*count;
            // 주어진 거리를 왕복*다녀온 횟수
        }
        return answer;
    }
}
