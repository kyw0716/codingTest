package sk000801.복습;
import java.util.*;

//46분
//정렬하는게 생각보다 쉽지 않고
//메뉴 수 안에서의 최댓값을 찾아줘야 함
public class 메뉴리뉴얼 {
    static List<String> list;
    public static void combi(List<String> all, int number, int depth, String s, int idx) {
        if(depth == number) {
            list.add(s);
            return;
        }

        for(int i = idx; i < all.size(); i++) {
            combi(all, number, depth+1, s+all.get(i), i+1);
        }
    }
    public static String[] solution(String[] orders, int[] course) {
        Set<String> all = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < orders.length; i++) {
            String[] s = orders[i].split("");
            for(int j = 0; j < s.length; j++) {
                all.add(s[j]);
            }
        }

        List<String> all2 = new ArrayList<>(all);
        Collections.sort(all2);

        for(int i = 0; i < course.length; i++) {
            list = new ArrayList<>();
            combi(all2, course[i], 0, "", 0);
            for(int j = 0; j < list.size(); j++) {
                map.put(list.get(j), 0);
            }
        }
        
        //s글자를 s2에서 모두 포함하고 있어야 함 그러나 contains는 연속된 문자만 검출함
        for(String s : map.keySet()) {
            String[] alpha = s.split("");
            for(String s3 : orders) {
                int count = 0;
                for(String s2 : alpha) {
                    if(s3.contains(s2)) count++;
                }
                if(count == alpha.length) map.put(s, map.get(s)+1);
            }
        }

        for(int i = 0; i < course.length; i++) {
            int max = 0;
            for(String s : map.keySet()) {
                if(s.length() == course[i]) {
                    max = Math.max(max, map.get(s));
                }
            }

            if(max <= 1) continue;
            // System.out.println(max);
            for(String s : map.keySet()) {
                if(s.length() == course[i] && map.get(s) == max) {
                    answer.add(s);
                }
            }
        }
        Collections.sort(answer);
        
        String[] ans = new String[answer.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2,3,4};
        
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2,3,5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2,3,4};

        String[] ans = solution(orders3, course3);
        for(String s : ans) {
            System.out.print(s+" ");
        }
    }
}
