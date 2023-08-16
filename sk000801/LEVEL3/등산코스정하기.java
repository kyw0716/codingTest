package sk000801.LEVEL3;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/118669
//어려워서 시간 재는게 의미가 없는 문제 .. (생각만 50분?)
//다만 그건 생각하고 가면 좋을듯 시작~봉우리까지의 최솟값 경우만 고려하면 됨
public class 등산코스정하기 {
    List<List<Node>> course;
    public class Node {
        int intensity, num;
        Node(int intensity, int num) {
            this.intensity = intensity;
            this.num = num;
        }
    }
    public int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intense = new int[n+1];
        Arrays.fill(intense, Integer.MAX_VALUE);
        
        for(int i = 0; i < gates.length; i++) {
            q.add(new Node(0, gates[i]));
            intense[gates[i]] = 0;
        }
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            for(int i = 0; i < course.get(cur.num).size(); i++) {
                Node next = course.get(cur.num).get(i);
                
                int dis = Math.max(next.intensity, intense[cur.num]);
                if(intense[next.num] > dis) {
                    intense[next.num] = dis;
                    q.add(new Node(dis, next.num));
                }
            }
        }
        
        int summitNum = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        Arrays.sort(summits);
        
        for(int i = 0; i < summits.length; i++) {
            if(intense[summits[i]] < minValue) {
                minValue = intense[summits[i]];
                summitNum = summits[i];
            }
        }
        
        return new int[]{summitNum, minValue};
    }
    public boolean contains(int[] arr, int val) {
        for(int a : arr) {
            if(a == val) return true;
        }
        return false;
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        course = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            course.add(new ArrayList<>());
        }
        
        for(int i = 0; i < paths.length; i++) {
            int s = paths[i][0];
            int num = paths[i][1];
            int intensity = paths[i][2];
            if(contains(gates,s) || contains(summits,num)) course.get(s).add(new Node(intensity, num));
            else if(contains(gates,num) || contains(summits,s)) course.get(num).add(new Node(intensity, s));
            else {
                course.get(s).add(new Node(intensity, num));
                course.get(num).add(new Node(intensity, s));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
}
