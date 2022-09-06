* import java.util.*;

class solution90 {
    public static int[] solution(int[] lottos, int[] win_nums) {
    int[] answer = new int[2];
    List<Integer> list = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();
    for (int i=0; i<6; i++) {
            list.add(lottos[i]);
            list2.add(win_nums[i]);
        }
    int zeroCount = Collections.frequency(list, 0); //0개수
    int count2 = Collections.frequency(list, 0);
    list.retainAll(list2); //중복된 수만 list에 남음
    int correctNumber = list.size(); 

    if(correctNumber < 2) answer[1] = 6;
    else answer[1] = 7 - correctNumber;
    if(zeroCount + correctNumber < 2) answer[0] = 6;
    else answer[0] = 7 - (zeroCount + correctNumber);
}
}
