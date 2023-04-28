package sk000801.LEVEL2;
import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/42890
//내가 푼게 아닌데도 48분,,
//항목의 개수에 따라 분류한뒤 최소성을 체크
class 후보키 {
    Set<String> set = new HashSet<>();
    public boolean isPossible(String hubos, boolean[] selected, String[][] relation) {
        //최소성이 만족되는지 확인
        //set에 있는 후보키가 가능한 항목들의 집합이 모두 포함되어 있는지 확인
        for(String s : set) {
            boolean check = true;
            for(int i = 0; i < s.length(); i++) {
                if(!hubos.contains(Character.toString(s.charAt(i)))) {
                    check = false;
                }
            }
            
            if(check) return false;
        }
        
        //입력받은 hubos 안의 컬럼 집합이 후보키가 되는지 확인
        //hubos가 156이면 name은 {1,5,6}
        HashSet<String> values = new HashSet<>();
        int[] name = new int[hubos.length()];
        int idx = 0;
        for(int i = 0; i < selected.length; i++) {
            if(selected[i]) name[idx++] = i;
        }
        
        //값에 중복이 있는지 확인
        //중복이 있다면 후보키 X
        //만약 들어온 hubo가 1,2,3인데
        //2,3이 이미 후보키로 확인이 되었다면 최소성 만족 X!!
        for(int i = 0; i < relation.length; i++) {
            String value = "";
            for(int j = 0; j < name.length; j++) {
                value += relation[i][name[j]];
            }
            if(values.contains(value)) {
                return false;
            } else {
                values.add(value);
            }
        }
        
        return true;
    }
    public void find(String[][] relation, int num, int depth, int idx, boolean[] selected) {
        if(depth == num) {
            String hubos = "";
            for(int i = 0; i < selected.length; i++) {
                //해당되는 컬럼?항목?의 인덱스 숫자를 넣어줌
                if(selected[i]) hubos += i;
            }
            
            //선택된 값이 후보키로 설정이 가능한지 확인
            if(isPossible(hubos, selected, relation)) {
                set.add(hubos);
            }
            
            return;
        }
        
        if(idx >= selected.length) return;
        
        selected[idx] = true;
        find(relation, num, depth+1, idx+1, selected);
            
        selected[idx] = false;
        find(relation, num, depth, idx+1, selected);
    }
    public int solution(String[][] relation) {
        for(int i = 1; i <= relation.length; i++) {
            boolean[] selected = new boolean[relation[0].length];
            find(relation, i, 0, 0, selected);
        }
        return set.size();
    }
}