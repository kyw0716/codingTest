import java.util.*;

class Solution {
    public int distance(int[]num, int[]num2) {
        int a = Math.abs(num[0]-num2[0]);
        int b = Math.abs(num[1]-num2[1]);
        return a+b;
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left=10;
        int right=12;
        Map<Integer, int[]> which = new HashMap<>();
        
        int[][] japyo = {
            {1,1}, {1,2}, {1,3}, {2,1}, {2,2}, {2,3}, {3,1}, {3,2}, {3,3}, 
            {4,1}, {4,2}, {4,3}
        };
        
        for(int i=1; i<=12; i++) {
            int[] a = japyo[i-1];
            if(i==11) {
                which.put(0, a);
            }
            which.put(i, a);
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