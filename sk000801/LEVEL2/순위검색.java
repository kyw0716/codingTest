package sk000801.LEVEL2;
//https://school.programmers.co.kr/learn/courses/30/lessons/72412
//교집합 요런거 찾는건디 어케한담
//43분 32초,, 기둘려 +11분(1차)+29분(효율성 마무리)
//역시나 효율성 2개가 걸린다..
//마지막에는 나는 for-if로 해당 점수를 넘으면 answer에 더해준 뒤 break를 했는데
//이것도 효율성이 안좋아 찾아보니 이분탐색을 하는 것이 좋다고 함.. (이참에 벨로그에 이분탐색도 적어보자)

//일단 풀이 순서
// 1. info에서 가능한 경우의 수를 map에다 담음
// 1+ 여기서 map은 <String, List<Integer>>로 String은 등장한 경우(4개의 값이 이어진)이고 List는 점수들을 담은 것이다
// 2. 다 담았다면 위의 List를 sort해준다(나중에 answer 계산할 때 효율적임)
// 3. query 배열을 돈다. (이때 and나 띄어쓰기를 제외하고 4개의 문자들을 배열에 담는다)
// 3+. 나머지 숫자들은 replaceAll로 걸러낸 뒤 -라면 0, 숫자라면 따로 저장한다
// 4. 이분탐색(인덱스의 시작과 끝을 start, end로 둠)을 통해 3+에서 저장해놓은 숫자보다 큰 최초의 인덱스를 찾는다
// 5. 리스트 길이 - 인덱스를 통해 answer 배열의 값을 구한다
import java.util.*;
class 순위검색 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        Map<String, List<Integer>> map = new HashMap<>();
        for(String s : info) {
            String[] mo = s.split(" ");
            String kind = "";
            for(int i = 0; i < 4; i++) {
                kind += mo[i];
            }
            int value = 0;
            if(!mo[4].equals("-")) value = Integer.parseInt(mo[4]);
            if(map.keySet().contains(kind)) {
                List<Integer> list = map.get(kind);
                list.add(value);
                map.put(kind, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(kind, list);
            }
        }
        
        for(String s : map.keySet()) {
            List<Integer> list = map.get(s);
            Collections.sort(list);
            map.put(s, list);
        }

        for(int i = 0; i < query.length; i++) {
            String text = query[i].replaceAll("[0-9]", "");
            query[i] = query[i].replaceAll("-", "");
            query[i] = query[i].replaceAll(" and", "");

            String[] s = query[i].split(" ");

            int num = 0;
            if(text.equals(s)) num = 0;
            else num = Integer.parseInt(query[i].replaceAll("[^0-9]", ""));
 
            for(String ss : map.keySet()) {
                int count = 0;
                for(int r = 0; r < 4; r++) {
                    if(ss.contains(s[r])) count++;
                }
                if(count == 4) {
                    List<Integer> list = map.get(ss);
                    int start = 0;
                    int end = list.size();
                    while(start < end) {
                        int mid = (start+end)/2;
                        if(list.get(mid) < num) start = mid+1;
                        else end = mid;
                    }
                    answer[i] += list.size()-start;
                }
            }
        }
        
        return answer;
    }
}