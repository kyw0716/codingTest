package sk000801.LEVEL2;
import java.util.*;
class Solution {
    //문자열을 분리해서 담을 때는 중복을 허용하여 담는다.
    public double solution(String str1, String str2) {
        String[] s1 = str1.toLowerCase().split("");
        String[] s2 = str2.toLowerCase().split("");
        //어떻게 하면 이 set을 더 줄일 수 있을까
        //map을 활용해 얼마나 반복되고 있는지 살펴봄
        //모든 문자열을 담을 생각하지 말고 그 개수에 대해 생각해봤어야됨
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> hap = new HashSet<>();

        for(int i = 0; i < s1.length-1; i++) {
            if(s1[i].matches("[a-z]") && s1[i+1].matches("[a-z]")) {
                String a = s1[i]+s1[i+1];
                map1.put(a, map1.getOrDefault(a, 0)+1);
                hap.add(a);
            }
        }
        for(int i = 0; i < s2.length-1; i++) {
            if(s2[i].matches("[a-z]") && s2[i+1].matches("[a-z]")) {
                String a = s2[i]+s2[i+1];
                map2.put(a, map2.getOrDefault(a, 0)+1);
                hap.add(a);
            }
        }        
        int all = 0;
        int answer = 0;
        for(String s : hap) {
            all += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
        }
        if(all==0) return 65536;
        for(String s : map2.keySet()) {
            if(map1.containsKey(s)) {
                answer += Math.min(map1.get(s), map2.get(s));
            }
        }
        
        return answer*65536/all;
    }
}
