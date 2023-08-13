package sk000801.LEVEL3;
import java.util.*;

//27분
//처음에 오름차순으로 정렬했다가 무언가 잘못됨을 깨달음 비슷한 문제를 백준에서 본 것 같은 느낌
public class 인사고과 {
    public int solution(int[][] scores) {
        int[] wh = scores[0];
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        });
        int score = scores[0][1];
        for(int i = 1; i < scores.length; i++) {
            if(score > scores[i][1]) { //인센티브 못받음
                if(scores[i][0] == wh[0] && scores[i][1] == wh[1]) return -1;
                //인센티브 못받는 애들은 아예 값을 작게 만들어버림
                //여기에 완호가 있으면 -1을 바로 리턴
                scores[i] = new int[]{-1,-1};
            } else {
                score = scores[i][1];
            }
        }    
        int answer = 1;
        Arrays.sort(scores, new Comparator<int[]>() { //합산점수 내림차순 정렬
            @Override
            public int compare(int[] a, int[] b) {
                return (b[0]+b[1])-(a[0]+a[1]);
            }
        });
        for(int i = 0; i < scores.length; i++) {
            //어차피 높은 점수에서 같은 값이 나와도 인원수 대로 등수가 체크됨
            if(scores[i][0]+scores[i][1] > wh[0]+wh[1]) answer++;
            else break;
        }
        return answer;
    }
}
