package sk000801.LEVEL2;
import java.util.*;

//처음엔 방문 배열을 활용하려 했으나 겹치는 점을 처음 지나도 방문으로 인식돼 문제 발생
//그래서 그냥 string을 활용해 이동전+이동후 or 이동후+이동전 문자열을 모두 set에 넣어 중복 제거
//두가지 경우를 모두 넣어줬기 때문에 정답은 2를 나눠줘야함
class Solution {
    public int solution(String dirs) {
        int[] temp = {0, 0};
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < dirs.length(); i++) {
            int x = temp[0];
            int y = temp[1];
            switch(Character.toString(dirs.charAt(i))) {
                case "U":
                    y++;
                    break;
                case "D":
                    y--;
                    break;
                case "R":
                    x++;
                    break;
                case "L":
                    x--;
                    break;
            }
            if(x < -5 || x > 5 || y < -5 || y > 5) continue;   
            set.add(""+x+y+temp[0]+temp[1]);
            set.add(""+temp[0]+temp[1]+x+y);
            temp[0] = x; temp[1] = y;
        }

        return set.size()/2;
    }
}