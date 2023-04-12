package sk000801.복습;
import java.util.*;

//38분,,인데,, 접근 방식은 비슷한데 중복을 또 못찾는듯 ㅠㅜㅠ 
//이 방식을 아예 String으로 바꿔 중복을 없애벌임!
public class 방문길이 {
    public static int solution(String dir) {
        Set<String> visit = new HashSet<>();
        String[] s = dir.split("");
        int[] cur = {0, 0};
        for(String ss : s) {
            switch(ss) {
                case "U":
                    cur[0]--;
                    if(cur[0]<-5||cur[0]>5) {cur[0]++;continue;}
                    String num = "";
                    num += cur[0];
                    num += cur[1];
                    num += cur[0]+1;
                    num += cur[1];
                    visit.add(num);
                    break;
                case "D":
                    cur[0]++;
                    if(cur[0]<-5||cur[0]>5) {cur[0]--;continue;}
                    String num2 = "";
                    num2 += cur[0]-1;
                    num2 += cur[1];
                    num2 += cur[0];
                    num2 += cur[1];
                    visit.add(num2);
                    break;
                case "R":
                    cur[1]++;
                    if(cur[1]<-5||cur[1]>5) {cur[1]--;continue;}
                    String num3 = "";
                    num3 += cur[0];
                    num3 += cur[1]-1;
                    num3 += cur[0];
                    num3 += cur[1];
                    visit.add(num3);
                    break;
                case "L":
                    cur[1]--;
                    if(cur[1]<-5||cur[1]>5) {cur[1]++;continue;}
                    String num4 = "";
                    num4 += cur[0];
                    num4 += cur[1];
                    num4 += cur[0];
                    num4 += cur[1]+1;
                    visit.add(num4);
                    break;
            }
        }
        return visit.size();
    }
    public static void main(String[] args) {
        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";
        System.out.println(solution(dirs1));
        System.out.println(solution(dirs2));
    }
}
