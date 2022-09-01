package sk000801;
import java.util.*;

// 신고 결과 받기

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, ArrayList<String>> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        for(int i=0; i<report.length; i++) {
            ArrayList<String> arr = new ArrayList<String>();
            String[] split = report[i].split(" ");
            if(!map.containsKey(split[0])) { //key가 같다면
                if(!arr.contains(split[1])) continue; //배열 안에 존재한다면 생략
                else { //value 배열 안에 같은 id가 없다면
                    arr.add(split[1]); //배열에 새로 추가해줌
                    list.add(split[1]);
                }
            }
            list.add(split[1]);
            map.put(split[0], arr); //key, value가 list은 map 값 추가
        }

        System.out.println(map.values());

        for(int p=0; p<id_list.length; p++) {
            map2.put(id_list[p], 0); // 일단 0으로 설정
        }
        for(int j=0; j<id_list.length; j++) {
            if(Collections.frequency(list, id_list[j])>=k) {
                map2.put(id_list[j], map2.get(id_list[j]+1));
            }
            int ans = map2.get(id_list[j]);
            answer[j] = ans;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        solution(id_list, report, 2);
    }
}
