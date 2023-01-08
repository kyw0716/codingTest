package sk000801.백준.bfs연습;
import java.io.*;
import java.util.*;

public class 트리의부모찾기 {
    static int n;
    static int[][] node;
    static int[] answer;
    static boolean[] visited;
    static Queue<Integer> q;
    static List<Integer> list[];

    public static void bfs() {
        q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int num = q.poll();

            for(Integer i : list[num]) {
                if(!visited[i]) {
                    answer[i] = num;
                    visited[i] = true;
                    q.add(i);
                }
            }

            System.out.println(q);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        answer = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 1; i <= n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();

        for(int i = 2; i <= n; i++) {
            System.out.println(answer[i]);
        }
    }
}

//아니 얘는 뭔소린지 당최 모르겠다
//왜 bfs인지 잘 몰라서 처음에는 2차원 배열로 담아 값을 1로 지정해주고
//2~n까지의 인덱스로 배열을 돌며 해당 인덱스일 때 값이 1이 되는 수를 정답에 담음
//그렇게 되니까 (6,3) (3,5)로 담겨있을 때는 6이 부모 노드인데 숫자가 더 앞인 5가 담김 
//뭔가 이상함을 감지하고 bfs로 식을 다시 세움(visited와 배열안에 리스트?? 활용)