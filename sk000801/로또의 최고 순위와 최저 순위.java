
    import java.util.*;

class Solution9 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        List<Integer> intList = new ArrayList<>();        
        for (int element : lottos) {           
            intList.add(element); 
        }

        if(!intList.contains(0)) {
            int count=0;
            for(int i=0; i<6; i++) {
                if(lottos[i] == win_nums[i]) {count+=1;}
            }
            if(count<=1) {
                answer[0] = 6;
                answer[1] = 6;
            }
            else {
                answer[0] = 7-count;
                answer[1] = 7-count;
            }
            
        }
        else { //어쨌든 0이 하나 이상 있으니까 겹치는 수 0~5
            List<Integer> list = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            for (int i=0; i<6; i++) {
                list.add(lottos[i]);
                list2.add(win_nums[i]);
            }
            int count2 = Collections.frequency(list, 0); //0개수
            list.retainAll(list2); //중복된 수만 list에 남음
            int count3 = 6-list.size(); //중복되지 않는 수 
            for(int j=1; j<5; j++) {
                if(count3==j) {
                    answer[0] = j+1-count2;
                    answer[1] = j+1;
                }
            }
            for(int p=5; p<7; p++) {
                if(count3==p) {
                    answer[0] = 7-count2;
                    answer[1] = 6;
                }
            }
    }
    return answer;
}
}


