package sk000801;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int length = (int)( Math.log10(n)+1 );
        for(int i=1; i<=length; i++) {
            answer += n % 10;
            n /= 10;
        }
        return answer;
    }
}