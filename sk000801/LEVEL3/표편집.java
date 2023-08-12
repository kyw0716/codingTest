package sk000801.LEVEL3;
//56분 .. 
//삭제하는데 stack을 쓰니까 굳이 얘가 삭제됐는지 확인하는 boolean 배열은 필요없을듯
//그리고 StringBuilder의 insert를 쓰라는 힌트를 얻고 시간 초과 막았다!
import java.util.*;
public class 표편집 {
    public String solution(int n, int k, String[] cmd) {
        int cur = k;
        Stack<Integer> delete = new Stack<>();
        for(String s : cmd) {
            if(s.contains("U")) {
                int num = Integer.parseInt(s.replace("U ", ""));
                cur -= num;
            }
            if(s.contains("D")) {
                int num = Integer.parseInt(s.replace("D ", ""));
                cur += num;
            }
            if(s.contains("C")) {
                delete.push(cur);
                n--;
                if(cur == n) cur--;
            }
            if(s.contains("Z")) {
                if(delete.pop() <= cur) cur++;
                n++;
            }
        }
       
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append("O");
        }
        while(!delete.isEmpty()) {
                sb.insert(delete.pop(), "X");
        }
        return sb.toString();
    }
}