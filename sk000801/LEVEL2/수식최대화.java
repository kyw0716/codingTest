package sk000801.LEVEL2;
//51분++
//어떻게 저렇게 바꿔도 답이 안나와서 풀이를 참조했는데
//그래도 그대로다..
import java.util.*;
class Solution {
    long answer;
    static String[] arr = {"-","*","+"};
    public void swap(int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public long cal(ArrayList<Long> nums, ArrayList<String> yeons) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < yeons.size(); j++) {
                if(yeons.get(j) == arr[i]) {
                    switch(arr[i]) {
                        case "-":
                            nums.add(j, nums.remove(j) - nums.remove(j));
                            break;
                        case "*":
                            nums.add(j, nums.remove(j) * nums.remove(j));
                            break;
                        case "+":
                            nums.add(j, nums.remove(j) + nums.remove(j));
                            break;
                    }
                    yeons.remove(j--);
                }       
            }
        }
        return Math.abs(nums.get(0));
    }
    public void perm(ArrayList<Long> nums, ArrayList<String> yeons, int depth) {
        if(depth == 3) {
            ArrayList<Long> num2 = (ArrayList<Long>) nums.clone();
            ArrayList<String> yeon2 = (ArrayList<String>) yeons.clone();
            long temp = cal(num2, yeon2);
            System.out.println(temp);
            if(temp > answer) answer = temp;
            return;
        }
        
        for(int i = depth; i < 3; i++) {
            swap(i, depth);
            perm(nums, yeons, depth+1);
            swap(i, depth);
        }
    }
    public long solution(String expression) {
        String[] num = expression.replaceAll("[^0-9]", " ").split(" ");
        ArrayList<Long> nums = new ArrayList<>();
        for(int i = 0; i < num.length; i++) {
            nums.add(Long.parseLong(num[i]));
        }
        String[] yeon = expression.replaceAll("[0-9]", "").split("");
        ArrayList<String> yeons = new ArrayList<>();
        for(int i = 0; i < yeon.length; i++) {
            yeons.add(yeon[i]);
        }

        perm(nums, yeons, 0);
        return answer;
    }
}
