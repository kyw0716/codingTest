package sk000801.LEVEL3;
import java.util.*;
//52분.. 마지막 시간 초과를 챙길 때 큐를 추가하며 풀이를 참고햇다.. 흑

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Queue<String> q = new LinkedList<>();
        
        int min = Integer.MAX_VALUE;
        //start는 정답 구간 시작, tempStart는 for문을 돌며 임시로 담는 구간 시작 인덱스
        int start = 0; int tempStart = 0;
        
        for(int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
            q.offer(gems[i]);
            
            while(true) {
                String cur = q.peek();
                //만약 가장 앞 인덱스의 문자 개수가 여러개라면 앞의 인덱스를 제거 (최소로 만들어주기 위함)
                //그리고 시작 구간 값을 1 늘림(당연함. 맨 앞의 인덱스가 사라짐)
                if(map.get(cur) > 1) {
                    q.poll();
                    map.put(cur, map.get(cur)-1);
                    tempStart++;
                } else break;
            }
            
            //map의 크기가 set과 같다(모든 보석들이 담겼다)
            //최솟값보다 구간(q)의 길이가 더 작다
            //이때 정답 구간을 갱신!
            if(map.size() == set.size() && min > q.size()) {
                min = q.size();
                start = tempStart;
            }
        }
        return new int[]{start+1, start+min};
    }
}

// 효율성에서 걸린 풀이ㅋ (그럴만도 함 map이 원하는 조건에 도달할 때마다 리스트를 정렬시키니..)
// public boolean isAll(Map<String, Integer> map, int size) {
//         if(map.size() == size) return true;
//         return false;
//     }
// public int[] solution(String[] gems) {
//         int[] answer = new int[2];
//         Set<String> set = new HashSet<>();        
//         for(String s : gems) {
//             set.add(s);
//         }
//         int size = set.size();
//         if(set.size() == 1) return new int[]{1, 1};
        
//         Map<String, Integer> map = new HashMap<>();
        
//         int min = Integer.MAX_VALUE;
//         for(int i = 0; i < gems.length; i++) {
//             map.put(gems[i], i+1);
//             if(i >= set.size()-1 && isAll(map, size)) {
//                 List<Integer> list = new ArrayList<>(map.values());
//                 Collections.sort(list);
//                 int cur = list.get(list.size()-1)-list.get(0)+1;
//                 if(min > cur) {
//                     min = cur;
//                     answer[0] = list.get(0);
//                     answer[1] = list.get(list.size()-1);
//                 }
//             }
//         }        
        
//         return answer;
// }
