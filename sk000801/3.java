package sk000801;
import java.util.*;

// 신고 결과 받기

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> set = Set.copyOf(Arrays.asList(report));
        String[] lists = set.toArray(new String[set.size()]);
       
         Map<String, Integer> result_map = new HashMap<>();
         for(int j=0; j<id_list.length; j++) {
            result_map.put(id_list[j], 0);
        }
        
        String[] singo = new String[lists.length];
        String[] dang = new String[lists.length];
        
        for(int p=0; p<lists.length; p++) {
            String[] split = lists[p].split(" ");
            singo[p] = split[0];
            dang[p] = split[1];
        }     
        
        for(int g = 0; g<dang.length; g++ ) {
            if(Collections.frequency(Arrays.asList(dang), dang[g])>=k) {
                result_map.put(singo[g], result_map.get(singo[g])+1);
            }
        }
        
         int[] answer = new int[id_list.length];
         for(int i=0; i<id_list.length; i++) answer[i] = result_map.get(id_list[i]);
         return answer;
    }
}
