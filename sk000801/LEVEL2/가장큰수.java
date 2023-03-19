package sk000801.LEVEL2;
import java.util.*;

//정렬을 어떻게 하냐가 관건인 문제
//처음에는 길이로 비교해서 더 큰 숫자를 비교했는데
//그냥 배열의 두 문자열을 a+b, b+a로 붙여 대소를 비교하여 두 문자열의 순서를 예측한다
//여기서 하나가 틀렸는데 모든 숫자가 0일때!! 모두 0이라면 000이 아니라 0만 출력되어야함
class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, new Comparator<String>() {
           @Override
            public int compare(String s1, String s2) {
                int a = Integer.parseInt(s1+s2);
                int b = Integer.parseInt(s2+s1);
                return a-b;
            }   
        });
        String answer = "";
        for(int i = nums.length-1; i >= 0; i--) {
            answer += nums[i];
        }
        if(answer.replaceAll("0","").equals("")) answer = "0"; 
        return answer;
    }
}
