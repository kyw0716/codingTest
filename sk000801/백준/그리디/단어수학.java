package sk000801.백준.그리디;

import java.io.*;
import java.util.*;

public class 단어수학 {
    //진짜 대박적인 생각
    //높은 자릿수부터 단위수를 곱해줘서 최댓값을 찾는다..

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for(int j = 0; j < s.length; j++) {
                if(!map.containsKey(s[j])) {
                    map.put(s[j], (int)Math.pow(10, s.length-j-1));
                } else {
                    map.put(s[j], map.get(s[j])+(int)Math.pow(10, s.length-j-1));
                }
            }
        }

        List<Integer> value = new ArrayList<>(map.values());
        value.sort(Integer::compareTo);
        int num = 9;

        for(int i = value.size()-1; i >= 0; i--) {
            answer += num*value.get(i);
            num--;
        }

        System.out.println(answer);
    }
}
