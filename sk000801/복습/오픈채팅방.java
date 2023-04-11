package sk000801.복습;
import java.util.*;

public class 오픈채팅방 {
    //https://school.programmers.co.kr/learn/courses/30/lessons/42888
    //7분컷!
    //최근 문제일수록 난이도가 더 높아지는 거 같긴 하다.. 얘는 괜찮지만..
    //Map을 통해 변화된 닉네임을 갱신해주는게 요지!
    public static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> inout = new ArrayList<>();

        for(int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if(!s[0].equals("Leave")) map.put(s[1], s[2]);
            inout.add(s[0]+" "+s[1]);
        }

        List<String> ans = new ArrayList<>();

        for(int i = 0; i < inout.size(); i++) {
            String[] s = inout.get(i).split(" ");
            if(s[0].equals("Enter")) {
                ans.add(map.get(s[1])+"님이 들어왔습니다.");
            } else if(s[0].equals("Leave")) {
                ans.add(map.get(s[1])+"님이 나갔습니다.");
            }
        }

        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] ans = solution(record);
        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
