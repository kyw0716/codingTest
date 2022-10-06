import java.util.*;

class Solution {
    public int distance(int[]num, int[]num2) {
        int a = Math.abs(num[0]-num2[0]);
        int b = Math.abs(num[1]-num2[1]);
        return a+b;
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=-999;
        int right=999;
        Map<Integer, int[]> which = new HashMap<>();
        
        for(int i=1; i<=12; i++) {
            int[] value = new int[2];
            if(i <= 3) {
                value[0] = 1;
                value[1] = i;
                which.put(i, value);
            }
            else if(i <= 6){
                 value[0] = 2;
                value[1] = i-3;
                which.put(i, value);
            }
            else if(i <= 9){
                value[0] = 3;
                value[1] = i-6;
                which.put(i, value);
            }
            else if(i == 10){
                value[0] = 4; 
                value[1] = 1;
                which.put(-999, value);
            }
            else if(i == 11){
                value[0] = 4;
                value[1] = 2;
                which.put(0, value);
            }
            else if(i == 12){
                value[0] = 4;
                value[1] = 3;
                which.put(999, value);
            }
        }
        
        for(int i=0; i<numbers.length; i++) {
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            }
            else{
                int[] arr = which.get(numbers[i]);
                int[] arr2 = which.get(left);
                int[] arr3 = which.get(right);
                if(distance(arr, arr2) == distance(arr, arr3)) {
                     if(hand.equals("left")) {
                        answer += "L";
                        left = numbers[i];
                    }
                    else {
                        answer += "R";
                        right = numbers[i];
                    }
                }
                else if(distance(arr, arr2) > distance(arr, arr3)) {
                    answer += "R";
                    right = numbers[i];
                }
                else {
                    answer += "L";
                    left = numbers[i];
                }
                
            }
        }
        return answer;
    }
}