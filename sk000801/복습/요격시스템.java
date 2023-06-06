package sk000801.복습;

import java.util.*;

//6분
//각 폭격 미사일의 끝 부분은 맞춰도 요격할 수 없다는 조건이 있기 때문에
//이전 미사일의 마지막 부분과 다음 미사일의 첫 부분이 겹쳐도 새로운 미사일을 발사해야함
public class 요격시스템 {
    public static int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });

        int answer = 1;
        int val = targets[0][1];
        for(int i = 1; i < targets.length; i++) {
            if(val <= targets[i][0]) {
                answer++;
                val = targets[i][1];
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution(targets));
    }   
}
