package sk000801.백준.그래프;
import java.util.*;

//유니온파인드 타파를 위해!
//https://www.acmicpc.net/problem/1043
public class 거짓말 {
    static int n, m; //n은 사람수, m은 파티수
    static List<List<Integer>> list = new ArrayList<>();
    static int[] parent;
    static boolean[] honest;
    public static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
    public static void union(int x, int y) {
        if(x==y) return;
        x = find(x);
        y = find(y);

        if(x<y) parent[y] = x;
        else if(x>y) parent[x] = y;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        parent = new int[n+1];
        honest = new boolean[51];
        m = in.nextInt();

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i <= m; i++) {
            list.add(new ArrayList<>());
        }

        int honestPeople = in.nextInt();
        for(int i = 0; i < honestPeople; i++) {
            int people = in.nextInt();
            honest[people] = true;
        }

        int pre = 0;
        for(int i = 1; i <= m; i++) {
            int a = in.nextInt();
            if(a>0) {
                //파티 번호(pre)를 따로 저장함
                pre = in.nextInt();
                list.get(i).add(pre);
            }
            for(int j = 1; j < a; j++) {
                //차례대로 리스트에 파티에 참여하는 사람들을 담음
                int people = in.nextInt();
                list.get(i).add(people);
                //파티 번호와 사람들을 합침(추후에 또 있으니까)
                union(pre, people);
            }
        }

        int parent;
        for(int i = 1; i < honest.length; i++) {
            if(honest[i]) honest[find(i)] = true;
        }

        int total = 0;
        for(int i = 1; i <= m; i++) {
            if(list.get(i).size()>0) {
                parent = find(list.get(i).get(0));
                if(!honest[parent]) total++;
            }
        }

        System.out.println(total);
    }
}
