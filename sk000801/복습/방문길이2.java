package sk000801.복습;
import java.util.*;

//11분
//풀이가 기억이 났다
//조건문도 조금 더 간편하게 적어봤따..
public class 방문길이2 {
    public static int solution(String dirs) {
        int curx = 0; int cury = 0;
        Set<String> set = new HashSet<>();
        String[] dir = dirs.split("");
        for(String s : dir) {
            String cur = "";
            switch(s) {
                case "L":
                    if(curx-1<-5) continue;
                    cur += curx-1;
                    cur += cury;
                    cur += curx;
                    cur += cury;
                    curx--;
                    break;
                case "R":
                    if(curx+1>5) continue;
                    cur += curx++;
                    cur += cury;
                    cur += curx;
                    cur += cury;
                    break;
                case "U":
                    if(cury+1>5) continue;
                    cur += curx;
                    cur += cury++;
                    cur += curx;
                    cur += cury;
                    break;
                case "D":
                    if(cury-1<-5) continue;
                    cur += curx;
                    cur += cury-1;
                    cur += curx;
                    cur += cury;
                    cury--;
                    break;
            }
            set.add(cur);
        }
        return set.size();
    }
    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";
        System.out.println(solution(dirs2));
    }
}
