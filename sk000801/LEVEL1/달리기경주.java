package sk000801.LEVEL1;
import java.util.*;
//18분
//해시맵 생각한건 신의 한수였
public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for(String s : callings) {
            int idx = map.get(s);
            String temp = players[idx-1];
            players[idx-1] = players[idx];
            players[idx] = temp;
            map.put(players[idx-1], idx-1);
            map.put(players[idx], idx);
        }
        return players;
    }
}
