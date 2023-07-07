package sk000801.LEVEL3;

public class 풍선터뜨리기 {
    public int solution(int[] a) {
        if(a.length == 1) return 1;
        
        // 50분..
        // 기준 풍선의 왼쪽 그룹과 오른쪽 그룹의 최솟값이 현재 풍선의 값보다 작다면
        // 그 풍선은 최종적으로 남을 수 없는 풍선
        // 모두 작다면 큰 값이 한번은 제거가 돼야 하므로 기준 풍선이 무조건 터질 것이기 때문
        int left = a[0];
        int[] right = new int[a.length];
        right[a.length-1] = a[a.length-1];
        
        for(int i = a.length-2; i >= 1; i--) {
            right[i] = Math.min(right[i+1], a[i]);
        }
        
        int answer = 2; //배열의 양 끝은 무조건 가능함!
        for(int i = 1; i < a.length-1; i++) {
            if(!(left < a[i] && right[i] < a[i])) {
                answer++;
            }
            left = Math.min(left, a[i]);
        }
        return answer;
    }
}