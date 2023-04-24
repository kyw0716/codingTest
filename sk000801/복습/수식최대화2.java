package sk000801.복습;
import java.util.*;

//드디어 22분컷!!
//인덱스를 하나씩 삭제해줘야지
//값만 삭제해주면 뭐하니!!!
public class 수식최대화2 {
    static String[] yeonsan = {"*-+", "*+-", "+*-", "+-*", "-*+", "-+*"};
    public static long solution(String expression) {
        long answer = 0;
        String[] num = expression.replaceAll("[^0-9]", " ").split(" ");
        String[] yeon = expression.replaceAll("[0-9]", "").split("");
        
        for(int i = 0; i < yeonsan.length; i++) {
            List<Long> nums = new ArrayList<>();
            List<String> yeons = new ArrayList<>();
            for(String s : num) {
                nums.add(Long.parseLong(s));
            }
            for(String s : yeon) {
                yeons.add(s);
            }
            String[] s = yeonsan[i].split("");
            for(int j = 0; j < s.length; j++) {
                for(int r = 0; r < yeons.size(); r++) {
                    if(yeons.get(r).equals(s[j])) {
                        long a = nums.get(r);
                        long b = nums.get(r+1);
                        nums.remove(r+1);
                        nums.remove(r);
                        if(s[j].equals("+")) {
                            nums.add(r, a+b);
                        } else if(s[j].equals("-")) {
                            nums.add(r, a-b);
                        } else {
                            nums.add(r, a*b);
                        }
                        yeons.remove(r);
                        r--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(nums.get(0)));
        }
        return answer;
    }
    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";
        System.out.println(solution(expression2));
    }
}
