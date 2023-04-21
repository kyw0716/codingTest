package sk000801.복습;
import java.util.*;

//처음에는 연산자 우선순위를 정해 우선순위가 높은것부터 앞뒤값을 계산해 더해주면 된다고 생각했는데
//그게 아니라 바뀐 값으로 넣어 계산을 해줘야 하기 때문에 완전 틀린 방식의 접근이었다,,
//41분 GG
//결국 해결!!
//6가지 경우를 for문을 돌려 연산을 한 뒤 최댓값을 찾아주었다...
public class 수식최대화 {
    //+, -, * 만 있는 연산
    static String[] yeon = {"+-*", "-+*", "+*-", "-*+", "*+-", "*-+"};
    static long max = 0;
    public static long cal(long n1, long n2, String ys) {
        long res = 0;
        switch(ys) {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
        }
        return res;
    }
    public static void solve(List<String> yeonsan, List<Long> num) {
        for(int i = 0; i < yeon.length; i++) {
            List<String> oper = new ArrayList<>();
            oper.addAll(yeonsan);
            List<Long> nums = new ArrayList<>();
            nums.addAll(num);
            String[] s = yeon[i].split("");
            for(int j = 0; j < s.length; j++) {
                for(int r = 0; r < oper.size(); r++) {
                    if(s[j].equals(oper.get(r))) {
                        long n1 = nums.get(r);
                        long n2 = nums.get(r+1);
                        long res = cal(n1, n2, oper.get(r));

                        nums.remove(r+1);
                        nums.remove(r);
                        oper.remove(r);

                        nums.add(r, res);
                        r--;
                    }
                }
            }
            max = Math.max(max, Math.abs(nums.get(0)));
        }
    } 
    public static long solution(String expression) {
        String[] s = expression.split("");
        List<String> yeonsan = new ArrayList<>();
        List<Long> num = new ArrayList<>();
        String temp = "";
        for(int i = 0; i < s.length; i++) {
            if(!s[i].replaceAll("[0-9]", "").equals("")) {
                yeonsan.add(s[i]);
                //map.put(s[i], map.getOrDefault(s[i], 0)+1);
                num.add(Long.parseLong(temp));
                temp = "";
            } else {
                temp += s[i];
            }
        }
        if(!temp.equals("")) num.add(Long.parseLong(temp));
        solve(yeonsan, num);
        return max;
    }
    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";
        System.out.println(solution(expression1));
    }
}
