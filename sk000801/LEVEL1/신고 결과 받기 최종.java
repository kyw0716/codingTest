import java.util.*;
//id_list에는 신고자 list
//report는 (신고자, 신고당한자)
//정지 기준의 신고 횟수 k
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
    int[] answer = new int[id_list.length];
    Set<String> set = new HashSet<String>(Arrays.asList(report)); //중복처리
    String[] split = set.toArray(new String[0]);
    String[][] report2 = new String[set.size()][2];
    Map<String, Integer> map = new HashMap<>(); // (아이디, 신고당한 횟수)
    Map<String, Integer> map2 = new HashMap<>(); // (아이디, 차단시킨 사람 수)

    for(int i=0 ; i<id_list.length; i++) {
    //각각의 HashMap에 기본값과 순서를 설정하기 위해 for문을 돌림
        map.put(id_list[i], 0);
        map2.put(id_list[i], 0);
    }
    for(int i=0; i<set.size(); i++) {
        // 입력받은 레포트를 띄어쓰기 기준으로 쪼개고 
        ///map에 신고당한 사람(쪼개진 기준 뒤쪽)에게 1만큼 씩 더함
        report2[i] = split[i].split(" ");
        map.put(report2[i][1], map.get(report2[i][1])+1);
    }
    for(int i=0; i<set.size(); i++) {
        //위에서 더해졌을 때 k번 이상 신고당했다면 report 배열의 신고한 사람(쪼개진 기준 앞쪽)에게 1만큼씩 더함
       if(map.get(report2[i][1]) >= k) map2.put(report2[i][0], map2.get(report2[i][0])+1);
    }
    for(int i=0; i<id_list.length; i++) {
        //answer에 차례대로 값을 넣어줌 (id_list 순서대로, map은 순서 정렬이 안됨)
        answer[i] = map2.get(id_list[i]);
    }
    return answer;
}

}
