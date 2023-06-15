package sk000801.복습;
import java.util.*;

//37분
public class 단체사진찍기 {
    static int ans = 0;
    static char[] val = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static Map<Character, Integer> map = new HashMap<>();
    public static boolean check(String[] data) {
        for(String s : data) {
            int idx1 = map.get(s.charAt(0));
            int idx2 = map.get(s.charAt(2));
            int compare = Character.getNumericValue(s.charAt(4))+1;
            if(s.charAt(3) == '=') {
                if(Math.abs(idx1-idx2) != compare) return false; 
            } else if(s.charAt(3) == '<') { 
                if(Math.abs(idx1-idx2) >= compare) return false;
            } else { 
                if(Math.abs(idx1-idx2) <= compare) return false;
            }
        }
        return true;
    }
    public static void dfs(String[] data, int depth, boolean[] visited, int[] order) {
        if(depth == 8) {
            map = new HashMap<>();
            for(int i = 0; i < order.length; i++) {
                map.put(val[i], order[i]);
            }
            if(check(data)) ans++;
            return;
        }

        for(int i = 0; i < 8; i++) {
            if(!visited[i]) {
                visited[i] = true;
                order[depth] = i;
                dfs(data, depth+1, visited, order);
                visited[i] =  false;
            }
        }
    }
    public static int solution(int n, String[] data) {
        int[] order = new int[8];
        boolean[] visited = new boolean[8];
        dfs(data, 0, visited, order);
        return ans;
    }
    public static void main(String[] args) {
        int n1 = 2; String[] data1 = {"N~F=0", "R~T>2"};
        System.out.println(solution(n1, data1));
    }
}
