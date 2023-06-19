package sk000801.LEVEL3;
import java.util.*;

//21분
//알아서 키 값이 낮다면 부모 노드 기준 왼쪽 자식 노드에
//키 값이 높다면 부모 노드 기준 오른쪽 자식 노드에
public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(String s : operations) {
            if(treeMap.isEmpty() && s.charAt(0) == 'D') continue;
            String[] ss = s.split(" ");
            if(s.charAt(0) == 'I') {
                int num = Integer.parseInt(ss[1]);
                treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
            } else if(ss[1].equals("-1")) {
                int min = treeMap.firstKey();
                if(treeMap.get(min) == 1) treeMap.remove(min);
                else treeMap.put(min, treeMap.get(min)-1);
            } else {
                int max = treeMap.lastKey();
                if(treeMap.get(max) == 1) treeMap.remove(max);
                else treeMap.put(max, treeMap.get(max)-1);
            }
        }
        if(treeMap.isEmpty()) return new int[]{0, 0};
        return new int[]{treeMap.lastKey(), treeMap.firstKey()};
    }
}
