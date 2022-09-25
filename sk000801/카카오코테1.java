import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] today_int = new int[3];
        Map<String, Integer> term = new HashMap<>();
        int[][] start1 = new int[privacies.length][3];
        String[] start2 = new String[privacies.length];
        int[] answer = new int[privacies.length];
        int j=0;

        String[] today_list = today.split("[.]");
        for(int i=0; i<3; i++) {
            today_int[i] = Integer.parseInt(today_list[i]);
        }

        for(int i=0; i<terms.length; i++) {
            String[] term2 = terms[i].split(" ");
            term.put(term2[0], Integer.parseInt(term2[1]));
        }
        for(int i=0; i<privacies.length; i++) {
            String[] arr1 =  privacies[i].split(" ");
            String[] arr2 =  arr1[0].split("[.]");
            start1[i] = Arrays.stream(arr2).mapToInt(Integer::parseInt).toArray();
            start2[i] = arr1[1];
        }
        for(int i=0; i<start2.length; i++) {
            int add_month = term.get(start2[i]);
            start1[i][1] += add_month;
            while(start1[i][1] > 12) {
                start1[i][0] += 1;
                start1[i][1] -= 12;
            }

            if(today_int[0]>start1[i][0]) {
                answer[j] = i+1;
                j ++;
            }
            else if(today_int[0] == start1[i][0]) {
                if(today_int[1] > start1[i][1]) {
                    answer[j] = i+1;
                    j++;
                }
                else if(today_int[1] == start1[i][1]) {
                    if(today_int[2] >= start1[i][2]) {
                        answer[j] = i+1;
                        j++;
                    }
                }
            }
        }
        int[] answer2 = new int[j];
        for(int i=0; i<j; i++) {
            answer2[i] = answer[i];
        }
        return answer2;
    }
}