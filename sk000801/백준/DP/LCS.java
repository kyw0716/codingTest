package sk000801.백준.DP;
import java.util.*;
//백준9251 https://www.acmicpc.net/problem/9251

//최장 공통 부분수열 
//부분수열 -> 문자 사이를 건너뛰어 공통되면서 가장 긴 문자열을 찾으면 돼

public class LCS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] s1 = in.nextLine().split("");
        String[] s2 = in.nextLine().split("");
        int[][] lcs = new int[s1.length+1][s2.length+1];

        for(int i = 1; i <= s1.length; i++) {
            for(int j = 1; j <= s2.length; j++) {
                // if(i==0 || j==0) lcs[i][j] = 0;
                if(s1[i-1].equals(s2[j-1])) lcs[i][j] = lcs[i-1][j-1]+1;
                //lcs[i][j]가 지금까지의 최대 공통 부분 수열 이래요
                else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }

        System.out.println(lcs[s1.length][s2.length]);
    }
}

// ACAYKP
// CAPCAK
