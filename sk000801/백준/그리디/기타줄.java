package sk000801.백준.그리디;

import java.io.*;
import java.util.*;

public class 기타줄 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int brand = Integer.parseInt(s[1]);
        int[] pack = new int[brand];
        int[] unit = new int[brand];
        int answer = 0;

        for(int i = 0; i < brand; i++) {
            String[] ss = br.readLine().split(" ");
            pack[i] = Integer.parseInt(ss[0]); //6줄 패키지
            unit[i] = Integer.parseInt(ss[1]); //하나 낱개
        }

        Arrays.sort(pack);
        Arrays.sort(unit);

        //가장 싼 패키지로 모두 살 때, 가장 싼 낱개로 모두 살 때, 6배수개만큼 패키지+남은거 낱개로
        answer = Math.min(pack[0]*(n/6+1), unit[0]*n);
        answer = Math.min(answer, (n/6)*pack[0]+(n%6)*unit[0]);

        System.out.println(answer);
    }
}
