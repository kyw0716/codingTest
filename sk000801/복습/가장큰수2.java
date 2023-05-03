package sk000801.복습;
import java.util.*;

//8분
//배열이 int형으로 정렬이 잘 안돼서
//String형으로 바꿔 풀었더니 바로 됐다 꺄
//고려하지 않은건 모든 숫자들이 0인 경우,,
public class 가장큰수2 {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] num = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            num[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String s1 = a+b;
                String s2 = b+a;
                int i1 = Integer.parseInt(s1);
                int i2 = Integer.parseInt(s2);
                return i2-i1;
            }
        });
        for(int i = 0; i < num.length; i++) {
            answer += num[i];
        }
        if(answer.replaceAll("[0]", "").equals("")) answer = "0";
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3,30,34,5,9};
        int[] numbers3 = {0,0,0,0,0};
        System.out.println(solution(numbers3));
    }
}
