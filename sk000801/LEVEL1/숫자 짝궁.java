// 겹치는 숫자가 아무것도 없을 때 return "-1";
// 겹치는 수에 0만 있을 때 return "0";
// 이외의 경우 겹치는 수들을 내림차순으로 정렬
    // 겹치는 하나의 숫자가 여러개 존재할 때 X의 숫자 개수 < Y의 숫자 개수 일때만 여러개 담기

//시간초과 코드
// import java.util.*;
// class Solution {
    
//     public int countRepeat(String[] num, String letter) {
//         int count = 0;
//         for(int i = 0; i < num.length; i++) {
//             if (num[i].equals(letter)) {
//                 count++;
//             }
//         }
//         return count;
//     }
    
//     public String addRepeatNumber(int common, String num) {
//         StringBuilder answer = new StringBuilder();
//         for(int i = 0; i < common; i++) {
//             answer.append(num);
//         }
//         return answer.toString();
//     }
    
//     public String solution(String X, String Y) {
//         String[] xList = X.split("");
//         String[] YList = Y.split("");
//         StringBuilder answer = new StringBuilder();
        
//         for(int i = 0; i < xList.length; i++) {
//             if (Y.contains(xList[i]) && !answer.toString().contains(xList[i])) {
//                 int common = Math.min(Collections.frequency(Arrays.asList(xList), xList[i]), countRepeat(YList, xList[i]));
//                 answer.append(addRepeatNumber(common, xList[i]));
//             } 
//         }
        
//         String realAnswer = answer.toString();
//         String answer1 = realAnswer;
        
//         if (realAnswer.equals("")) {
//             return "-1";
//         } else if (answer1.replaceAll("0","").equals("")) {
//             return "0";
//         } 
//             String[] sortAnswer = realAnswer.split("");
//             Arrays.sort(sortAnswer, Collections.reverseOrder());
//             return String.join("",sortAnswer);
        
//     }
// }    

import java.util.*;
class Solution {
    
    public String addAnswer(String number, int count) {
        StringBuilder num = new StringBuilder();
        for(int i = 0; i < count; i++) {
            num.append(number);
        }
        return num.toString();
    }
    
    public String solution(String X, String Y) {
        
        List<String> xSplit = Arrays.asList(X.split(""));
        List<String> ySplit = Arrays.asList(Y.split(""));

        Map<String, Integer> xNumbers = new HashMap<>();
        Map<String, Integer> yNumbers = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            xNumbers.put(index, 0);
            yNumbers.put(index, 0);
        }
        
        for(int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            if (X.contains(index)) {
                int common = Collections.frequency(xSplit, index);
                xNumbers.put(index, common);
            }
        }
                
        for(int i = 0; i < 10; i++) {
            String index = Integer.toString(i);
            if (Y.contains(index)) {
                int common = Collections.frequency(ySplit, index);
                 yNumbers.put(index, common);
            }
        }
        
        for(int i = 9; i >= 0; i--) {
            String index = Integer.toString(i);
            if (xNumbers.get(index) > 0 && yNumbers.get(index) > 0) {
                int min = Math.min(xNumbers.get(index), yNumbers.get(index));
                answer.append(addAnswer(index,min));
            }
        }
        
        String answer1 = answer.toString();

        if (answer1.equals("")) {
            return "-1";
        } else if (answer1.replaceAll("0","").equals("")) {
            return "0";
        }
        return answer1;
    }
}