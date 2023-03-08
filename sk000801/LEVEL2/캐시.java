package sk000801.LEVEL2;
import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();
        if(cacheSize == 0) {
            return cities.length*5;
        }
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        for(int i = 0; i < cities.length; i++) {
            if(list.size() < cacheSize) {
                if(list.contains(cities[i])) {
                    list.remove(cities[i]);
                    list.add(cities[i]);
                    answer++;
                } else {
                    list.add(cities[i]);
                    answer += 5;
                }
            } else { //이미 크기를 넘어감
                if(list.contains(cities[i])) {
                    answer++;
                    list.remove(cities[i]);
                    list.add(cities[i]);
                } else {
                    list.remove(0);
                    list.add(cities[i]);
                    answer += 5;
                }
            } 
        }
        return answer;
    }
}
