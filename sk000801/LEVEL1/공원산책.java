package sk000801.LEVEL1;
//33분 문제 조건을 제대로 안봐서ㅠㅠ 이런 멍청이
public class 공원산책 {
    int[] cur;
    public int[] solution(String[] park, String[] routes) {
        String[][] map = new String[park.length][park[0].length()];
        for(int i = 0; i < park.length; i++) {
            map[i] = park[i].split("");
            if(park[i].contains("S")) cur = new int[]{i, park[i].indexOf("S")};
        }
        int n = map.length;
        int m = map[0].length;
        for(String s : routes) {
            String[] command = s.split(" ");
            int num = Integer.parseInt(command[1]);
            boolean flag = true;
            switch(command[0]) {
                case "N":
                    if(cur[0]-num < 0) break;
                    for(int i = cur[0]-1; i >= cur[0]-num; i--) {
                        if(map[i][cur[1]].equals("X")) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) cur[0] -= num;
                    break;
                case "S":
                    if(cur[0]+num>=n) break;
                    for(int i = cur[0]+1; i <= cur[0]+num; i++) {
                        if(map[i][cur[1]].equals("X")) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) cur[0] += num;
                    break;
                case "W":
                    if(cur[1]-num<0) break;
                    for(int i = cur[1]-1; i >= cur[1]-num; i--) {
                        if(map[cur[0]][i].equals("X")) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) cur[1] -= num;
                    break;
                case "E":
                    if(cur[1]+num>=m) break;
                    for(int i = cur[1]+1; i <= cur[1]+num; i++) {
                         if(map[cur[0]][i].equals("X")) {
                             flag = false;
                            break;
                         }
                    }
                    if(flag) cur[1] += num;
                    break;
            }
        }

        return cur;
    }
}
