import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            if (stack.size()>3 && stack.elementAt(stack.size()-1) == 1 && stack.elementAt(stack.size()-2) == 3 && stack.elementAt(stack.size()-3) == 2 && stack.elementAt(stack.size()-4) == 1) {
                answer++;
                stack.pop();
                stack.pop();
                stack.pop();
                stack.pop();
            } 
        }
        return answer;
    }
}

        // StringBuilder ingredients = new StringBuilder();
        // for (int i = 0; i < ingredient.length; i++) {
        //     ingredients.append(ingredient[i]);
        // } 
        // String letter = ingredients.toString();
        // while(letter.contains("1231")) {
        //     letter = letter.replaceAll("1231","");
        // }
        // int answer = (ingredient.length - letter.length()) / 4;
        // return answer;