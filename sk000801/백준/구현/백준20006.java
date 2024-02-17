package sk000801.백준.구현;
import java.util.*;

//랭킹전 기능 추가 -> 비슷한 레벨의 플레이어들을 매칭하여 게임 시작
//매칭 가능한 방이 없다면 새로운 방을 생성해 입장 (-10 ~ +10까지)

public class 백준20006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.nextLine().split(" ");
        int p = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Map<Integer, List<String>> map = new HashMap<>();
        Map<String, Integer> room = new HashMap<>();

        for(int i = 0; i < p; i++) {
            s = in.nextLine().split(" ");
            int level = Integer.parseInt(s[0]);
            String player = s[1];

            room.put(player, level);

            List<Integer> keys = new ArrayList<>(map.keySet());
            boolean hasKey = false;
            for(int j = level-10; j <= level+10; j++) {
                if(keys.contains(j) && map.get(j).size() < m) {
                    List<String> list = map.get(j);
                    list.add(player);
                    map.put(j, list);
                    hasKey = true;
                    break;
                }
            }
            
            if(!hasKey) {
                List<String> list = new ArrayList<>();
                list.add(player);
                map.put(level, list);
            }
        }

        StringBuffer sb = new StringBuffer();
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int i = 0; i < keys.size(); i++) {
            List<String> list = map.get(keys.get(i));
            Collections.sort(list);
            
            if(list.size() == m) {
                sb.append("Started!\n");
            } else {
                sb.append("Started!\n");
            }

            for(int j = 0; j < list.size(); j++) {
                String ss = list.get(j);
                sb.append(room.get(ss)).append(" ").append(ss).append("\n");
            }
        }

        System.out.println(sb);
    }
}
