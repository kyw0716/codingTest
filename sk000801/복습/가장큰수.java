package sk000801.복습;
import java.util.*;

//14분인데
//풀이 참조한 문제..
//자릿수별로 비교하려 했는데(아마 그때도 그랬던 거 같음)
//이거 두 숫자의 자릿수를 알아야 하기 때문에 어려움..
//근데 두 숫자를 문자열로 바꿔 더해주면 두 수중 어떤게 더 자릿수가 큰지? 알 수 있우니까!
public class 가장큰수 {
    public static String solution(int[] numbers) {
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                int x = Integer.parseInt(a+b);
                int y = Integer.parseInt(b+a);
                return y-x;
            }
        });
        String answer = "";
        for(int i = 0; i < num.length; i++) {
            answer += num[i];
        }
        if(answer.replaceAll("0", "").equals("")) answer = "0";
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
        System.out.println(solution(numbers2));
    }
}
