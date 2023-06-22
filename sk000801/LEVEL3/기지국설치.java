package sk000801.LEVEL3;
//전파가 도달하지 않는 빈 공간을 배열로 나눠 ..
//빈 공간의 범위에서 최솟값은 올림(길이/2*w+1)
//로직은 잘 구현했는데 최종 테케들에서 문제가 많아서 ?? 했다가
//리스트에서 앞의 값이 뒤 값보다 커질때? 의 경우를 제하지 않아서 값이 -가 되지 않았나(ㅋ) 싶다..
//42분
import java.util.*;
public class 기지국설치 {
    public int solution(int n, int[] stations, int w) {
        List<int[]> list = new ArrayList<>();
        int answer = 0;

        if(stations[0] != 1 && stations[0]-w-1 >= 1) list.add(new int[]{1, stations[0]-w-1});
        for(int i = 1; i < stations.length; i++) {
            if(stations[i-1]+w+1 <= stations[i]-w-1) {
                list.add(new int[]{stations[i-1]+w+1, stations[i]-w-1});
            }
        }
        if(stations[stations.length-1] < n && stations[stations.length-1]+w+1 <= n) list.add(new int[]{stations[stations.length-1]+w+1, n});
        
        for(int i = 0; i < list.size(); i++) {
            int[] range = list.get(i);
            int length = range[1]-range[0]+1;
            if(length <= 2*w+1) answer++;
            else if((double)length/(2*w+1) - (int)length/(2*w+1) > 0.0) answer += (int)((double)length/(2*w+1))+1;
            else answer += (int)((double)length/(2*w+1));
            //(int)(Math.ceil((double)length/(2*w+1)));
        }
        
        return answer;
    }
}