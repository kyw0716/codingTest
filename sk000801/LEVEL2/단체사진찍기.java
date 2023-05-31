package sk000801.LEVEL2;
import java.util.*;
class Solution {
    static int answer;
    static String[] friends1 = {"A", "C", "F", "J", "M", "N", "R", "T"};
    static Map<Character, Integer>  map;
    //res는 위의 friends 값의 인덱스를 섞어놓은것,,
    //순열을 통해 모든 경우의 수를 구하고(8!), 이게 정답이 되는지 체크
    //40분+38분
    //로직은 다 구현했는데 문제는 시간초과
    //배열->HashMap에서 get방식을 활용해 시간복잡도 줄임
    //String문제 -> Character로 바꿔 굳이 String 배열을 선언하지 않음
    public boolean check(int[] res, String[] data) {
        for(String s : data) {
            int idx1 = res[map.get(s.charAt(0))];
            int idx2 = res[map.get(s.charAt(2))];
            int val = Character.getNumericValue(s.charAt(4))+1;
            
            if(s.charAt(3) == '=') {
                if(Math.abs(idx1-idx2) != val) return false;
            } else if(s.charAt(3)==('>')) { //초과
                if(!(Math.abs(idx1-idx2) > val)) return false;
            } else if(s.charAt(3)==('<')) { //미만
                if(!(Math.abs(idx1-idx2) < val)) return false;
            }
        }
        return true;
    }
    public void dfs(int depth, String[] data, int[] res, boolean[] visited) {
        if(depth == 8) {
            if(check(res, data)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                res[depth] = i;
                dfs(depth+1, data, res, visited);
                visited[i] = false;
            }
        }
    }
    public int solution(int n, String[] data) {
        answer = 0;
        int[] res = new int[8];
        boolean[] visited = new boolean[8];
        map = new HashMap<>();
        
        for(int i = 0; i < 8; i++) {
            map.put(friends1[i].charAt(0), i);
        }
        
        dfs(0, data, res, visited);
        return answer;
    }
}