package sk000801.LEVEL3;

import java.util.*;
//테케1을 예시로 들자면
//set1은 5
//set2는 55, 5+5, 5-5, 5*5, 5/5 
//set3은 555, set1과 set2사이 수의 사칙연산
//.. 그 이후부터 똑같이 set3처럼 돌아감
//사실 마지막에 5->55->555를 넣는데에서 헛발질을 했으나 repeat이라는 좋은 문자열 반복 함수를 얻어감!
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= 8; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);
        for(int i = 2; i <= 8; i++) {
            Set<Integer> set1 = list.get(i);
            for(int j = 1; j <= i; j++) {
                Set<Integer> set2 = list.get(j);
                Set<Integer> set3 = list.get(i-j);
                
                for(int num1 : set2) {
                    for(int num2 : set3) {
                        set1.add(num1+num2);
                        set1.add(num1*num2);
                        set1.add(num1-num2);
                        if(num1 != 0 && num2 != 0) {
                            set1.add(num1/num2);
                        } 
                    }
                }
            }
            set1.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        
        for(Set<Integer> set : list) {
            if(set.contains(number)) {
                return list.indexOf(set);
            }
        }

        return -1;
    }
}
