package sk000801.LEVEL2;

import java.util.*;
//10분!!
//오랜만에 2레벨 치고 풀만한 문제!
class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[col-1] == b[col-1]) return b[0]-a[0];
                return a[col-1]-b[col-1];
            }
        });
        int[] val = new int[row_end-row_begin+1];
        for(int i = row_begin-1; i <= row_end-1; i++) {
            for(int j = 0; j < data[0].length; j++) {
                val[i-(row_begin-1)] += data[i][j]%(i+1);
            }
        }
        if(val.length == 1) return val[0];
        int answer = val[0]^val[1];
        
        if(val.length > 2) {
            for(int i = 2; i < val.length; i++) {
                answer = answer^val[i];
            }
        }
        
        return answer;
    }
}
