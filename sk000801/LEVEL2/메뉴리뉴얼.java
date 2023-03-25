package sk000801.LEVEL2;

//주어진 코스의 개수별로 최대로 쓰인 요리들을 찾음
//주어진 단품 메뉴들을 일단 set으로 받아놓음
//그리고 개수를 조합해서 최대 개수를 찾아주면 될듯
//최대개수를 찾아줄 때는 따로따로 메뉴가 존재하는지 확인해야댐 ㅠㅠ
import java.util.*;
class Solution {
    public int countNum(String[] orders, String s) {
        int count = 0;
        String[] arr = s.split("");
        for(int i = 0; i < orders.length; i++) {
            int count2 = 0;
            for(int j = 0; j < arr.length; j++) {
                if(orders[i].contains(arr[j])) count2++;
            }
            if(count2 == arr.length) count++;
        }
        return count;
    }
    public void create(Set<String> courses, List<String> food, int idx, int depth, String s, int n) {
        if(depth == n) {
            courses.add(s);
            return;
        }
        
        for(int i = idx; i < food.size(); i++) {
            create(courses, food, i+1, depth+1, s+food.get(i), n);
        }
    }
    public String[] solution(String[] orders, int[] course) {
        List<String> ans = new ArrayList<>();
        Set<String> food = new HashSet<>();
        for(int i = 0; i < orders.length; i++) { //모든 단품 음식들을 추가
            String[] s = orders[i].split("");
            for(int j = 0; j < s.length; j++) {
                food.add(s[j]);
            }
        }
        List<String> foods = new ArrayList<>(food);
        Collections.sort(foods);
        for(int i = 0; i < course.length; i++) { //조합할 수 있는 주어진 개수의 코스 만들기
            Set<String> courses = new HashSet<>();
            create(courses, foods, 0, 0, "", course[i]);
            int max = 0;
            List<String> course2 = new ArrayList<>(courses);
            for(int j = 0; j < course2.size(); j++) {
                max = Math.max(countNum(orders, course2.get(j)), max);
            }
            
            if(max <= 1) break;
            
            for(int r = 0; r < course2.size(); r++) {
                if(countNum(orders, course2.get(r)) == max) {
                    ans.add(course2.get(r));
                }
            }
        }
        
        Collections.sort(ans);
        String[] answer = new String[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
