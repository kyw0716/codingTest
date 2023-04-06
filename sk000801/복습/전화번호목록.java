package sk000801.복습;
import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/42577
//startWith와 함께 8분컷...
public class 전화번호목록 {
    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        //그냥 문자 배열을 sort하면 사전 순으로 배열이 정렬되므로
        //앞뒤 배열값끼리 비교해도됨! (그렇게 해서 O(N)이 되는듯)
        for(int i = 0; i < phone_book.length; i++) {
            if(phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] s = {"119", "97674223", "1195524421"};
        System.out.println(solution(s));
    }
}
