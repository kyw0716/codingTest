package sk000801.백준.복습;
import java.util.*;

//-기준으로 나눠 계산한 뒤 뺄셈만 진행!
//+는 기호가 따로 있는 듯 \\+로 생각!!
public class 잃어버린괄호 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s = in.nextLine().split("-");
        List<Integer> num = new ArrayList<>();

        for(int i = 0; i < s.length; i++) {;
            if(s[i].contains("+")) {
                int total = 0;
                String[] s2 = s[i].split("\\+");
                for(int j = 0; j < s2.length; j++) {
                    total += Integer.parseInt(s2[j]);
                }
                num.add(total);
            }
            else num.add(Integer.parseInt(s[i]));
        }

        int ans = num.get(0);
        if(num.size()>1) {
            for(int i = 1; i < num.size(); i++) {
                ans -= num.get(i);
            }
        }   

        System.out.println(ans);
    }
}
