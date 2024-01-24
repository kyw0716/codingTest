package sk000801.LEVEL3;

// A가 승리할 확률이 높아지기 위해 골라야 하는 주사위 번호
// dice배열 = 각각의 주사위 숫자
// 시간초과때메 2시간도 넘었지만 결국 2개가 해결되지 못함..
import java.util.*;

class Solution {
    int max = 0;
    int[] answer;
    
    public void getSum(Map<Integer, Integer> map, int[] ans, int[][] dice, int depth, int sum) {
        if(depth == ans.length) {
            map.put(sum, map.getOrDefault(sum, 0)+1);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            getSum(map, ans, dice, depth+1, sum+dice[ans[depth]][i]);
        }
    }
    
    public int calculate(int[] ans, int[] compare, int[][] dice) {
        int answer = 0;
        
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        getSum(map1, ans, dice, 0, 0);
        getSum(map2, compare, dice, 0, 0);
        
        
        List<Integer> list1 = new ArrayList<>(map1.keySet());
        List<Integer> list2 = new ArrayList<>(map2.keySet());
        Collections.sort(list2);
    

        for(int i = 0; i < list1.size(); i++) {
            for(int j = 0; j < list2.size(); j++) {
                int start = 0;
                int fin = list2.size();
                
                while(start+1 < fin) {
                    int mid = (start+fin)/2;
                    
                    if(list1.get(i) > list2.get(mid)) {
                        answer += map1.get(list1.get(i))*map2.get(list2.get(mid));                        
                        start = mid;
                    } else {
                        fin = mid;
                    }
                }
                // if(list1.get(i) > list2.get(j)) {
                //     answer += map1.get(list1.get(i))*map2.get(list2.get(j));
                // } else {
                //     break;
                // }
            }
        }
        
        return answer;
    }
    
    public void perm(int start, int depth, int[] ans, int[][] dice, boolean[] visited) {
        if(depth == ans.length) {
            Integer[] ans2 = new Integer[ans.length];
            for(int i = 0; i < ans.length; i++) {
                ans2[i] = ans[i];
            }
            List<Integer> list = new ArrayList<>(Arrays.asList(ans2));

            int[] compare = new int[dice.length/2];
            int idx = 0;
            for(int i = 0; i < dice.length; i++) {
                if(!list.contains(i)) {
                    compare[idx++] = i;
                }
            }

            int result = calculate(ans, compare, dice);

            if(result > max) {
                answer = Arrays.copyOf(ans, ans.length);
                max = result;
            }
            return;
        }
        
        for(int i = start; i < dice.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                ans[depth] = i;
                perm(start+1, depth+1, ans, dice, visited);
                visited[i] = false;
            }
        }
    }
    
    public int[] solution(int[][] dice) {
        answer = new int[dice.length/2];
        int[] temp = new int[dice.length/2];
        boolean[] visited = new boolean[dice.length];
        
        perm(0, 0, temp, dice, visited);
        int[] realAnswer = new int[answer.length];
        for(int i = 0; i < answer.length; i++) {
            realAnswer[i] = answer[i]+1;
        }
        return realAnswer;
    }
}