package sk000801.백준.브루트포스;
import java.util.*;

//뭔가 내 생각은 존재하는 치킨집 중 세개를 고르는 함수와
//그때의 치킨 거리를 구해 비교하는 함수 두개를 만들어야 할 거 같음
public class 치킨배달 {
    static int n, m;
    static ArrayList<japyo> home;
    static ArrayList<japyo> chicken;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE; //최솟값 ㅏ가려내는
    static class japyo {
        int x, y;
        japyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int dist(List<japyo> chicken) { //치킨 거리 계산하는
        int count = 0;
        for(int i = 0; i < home.size(); i++) {
            japyo jap = home.get(i);
            int min = 1000000;
            for(int j = 0; j < chicken.size(); j++) {
                min = Math.min(min, Math.abs(jap.x-chicken.get(j).x)+Math.abs(jap.y-chicken.get(j).y));
            }
            count += min;
        }
        return count;
    }
    public static void dfs(int idx, int depth) { //치킨집 m개 골라내는 
        if(depth == m) {
            List<japyo> realChicken = new ArrayList<>();
            for(int i = 0; i < chicken.size(); i++) {
                if(visited[i]) realChicken.add(chicken.get(i));
            }
            min = Math.min(min, dist(realChicken));
            return;
        }

        for(int i = idx; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i+1, depth+1);
            visited[i] = false;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        home = new ArrayList<>();
        chicken = new ArrayList<>();        

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                int n = in.nextInt();
                if(n == 1) home.add(new japyo(i, j));
                if(n == 2) chicken.add(new japyo(i, j));
            }
        }
        visited = new boolean[chicken.size()];

        dfs(0, 0);

        System.out.println(min);
    }
}
