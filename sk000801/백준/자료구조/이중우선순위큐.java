package sk000801.백준.자료구조;
import java.io.*;
import java.util.*;

//우선순위큐에서 remove함수는 n의 시간복잡도를 가진다
//그러나 여기서는 data가 많은 탓에 logn안에서 처리를 해야 한다
//그래서 불러온 것이 treeMap!
//treeMap은 key값을 기준으로 정렬
public class 이중우선순위큐 {
    static StringBuffer sb = new StringBuffer("");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            // PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
            // PriorityQueue<Integer> pq2 = new PriorityQueue<>();

            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < n; j++) {
                StringTokenizer s = new StringTokenizer(br.readLine());
                String command = s.nextToken();
                int num = Integer.parseInt(s.nextToken());
                if(treeMap.isEmpty() && command.equals("D")) continue; 
                if(command.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
                } else if(command.equals("D") && num == -1) {
                    int min = treeMap.firstKey();
                    if(treeMap.get(min) == 1) treeMap.remove(min);
                    else treeMap.put(min, treeMap.get(min)-1);
                } else if(command.equals("D") && num == 1) {
                    int max = treeMap.lastKey();
                    if(treeMap.get(max) == 1) treeMap.remove(max);
                    else treeMap.put(max, treeMap.get(max)-1);
                }
            }

            if(!treeMap.isEmpty()) {
                sb.append(treeMap.lastKey()+" "+treeMap.firstKey()+"\n");
            } else {
                sb.append("EMPTY\n");
            }
        }

        System.out.println(sb);
    }
}
