
    import java.util.*;

class Solution9 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i=0; i<6; i++) {
                list.add(lottos[i]);
                list2.add(win_nums[i]);
            }
        // int zeroCount = Collections.frequency(list, 0); //0개수
        int count2 = Collections.frequency(list, 0);
        list.retainAll(list2); //중복된 수만 list에 남음
        // int correctNumber = list.size(); 

        // if(correctNumber < 2) answer[1] = 6;
        // else answer[1] = 7 - correctNumber;
        // if(zeroCount + correctNumber < 2) answer[0] = 6;
        // else answer[0] = 7 - (zeroCount + correctNumber);
        if(count2==0) {
            //중복되는 수
            if(list.size() <= 1) {
                    answer[0] = 6;
                    answer[1] = 6;
                }
            else{
                answer[0] = 7-list.size();
                answer[1] = 7-list.size();
            }         
        }
        else if(count2>0) { //어쨌든 0이 하나 이상 있으니까 겹치는 수 0~5
            int count3 = 6-list.size(); //중복되지 않는 수
            if(count3 >= 1 && count3 <= 4){
                answer[0] = count3 + 1 - count2;
                answer[1] = count3 + 1;
            }
            else{
                 answer[0] = 7-count2;
                 answer[1] = 6;
            }
        }
        return answer;
}
}


