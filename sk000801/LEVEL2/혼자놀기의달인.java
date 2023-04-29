import java.util.*;
//23분
//처음에는 무슨 말인지 모르겠어서 문제 설명을 읽어봤는데
//인덱스 값+1로 시작을 해서 그 인덱스 안의 값의 인덱스로 이동을 하라는 얘기였다
//[8,6,3,7,2,5,1,4] 이라면
// 1 -> 첫번째 인덱스 8 -> 8번째 인덱스 4 -> 4번째 인덱스 7 -> 7번째 인덱스 1 끝! 요런식으로
//마지막에 고려하지 않은건 한번에 모든 카드를 다 열었을 때!!
class 혼자놀기의달인 {
    public int solution(int[] cards) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < cards.length; i++) {
            Set<Integer> group = new HashSet<>();
            group.add(i);
            group.add(cards[i]-1);
            int cur = i;
            while(cards[cur]-1 != i) {
                cur = cards[cur]-1;
                group.add(cur);
            }
            if(group.size() == cards.length) return 0;
            //Collections.sort(group);
            if(!list.contains(group)) list.add(group);
        } 
        Collections.sort(list, new Comparator<Set<Integer>>() {
            @Override
            public int compare(Set<Integer> list1, Set<Integer> list2) {
                return list2.size()-list1.size();
            }
        });
        // System.out.println(list);
        return list.get(0).size()*list.get(1).size();
    }
}