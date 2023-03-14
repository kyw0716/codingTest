package sk000801.LEVEL2;
import java.util.*;

//난생처음보는 접두사 함수? startsWith()를 기억하라는 문제 같음
//그냥 정렬을 해도 문제가 풀리넹
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i = 0; i < phone_book.length-1; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }
}
