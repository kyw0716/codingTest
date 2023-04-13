package sk000801.복습;
import java.util.*;

//22분에서 크롬 페이지를 꺼놔서 아마 30분..?
//Arrays.sort()를 해야한다는 사실을 가장 먼저 까먹었고
//head를 만드는 과정을 혼자 복잡하게 풀고 있었다!!!
//마지막에는 number의 글자가 5개가 안되는 경우를 고려하지 않아서 틀렸..
public class 파일명정렬 {
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();

                String head1 = "";
                String head2 = "";
                String number1 = "";
                String number2 = "";

                head1 = s1.split("[0-9]")[0];
                head2 = s2.split("[0-9]")[0];

                if(head1.compareTo(head2) != 0) return head1.compareTo(head2);

                String[] s = s1.split("");
                String[] ss = s2.split("");
                
                int count = 0;
                for(int i = head1.length(); i < s.length; i++) {
                    if(s[i].replaceAll("[0-9]", "").equals("") && count < 5) {number1 += s[i]; count++;}
                    else break;
                }
                count = 0;
                for(int i = head2.length(); i < ss.length; i++) {
                    if(ss[i].replaceAll("[0-9]", "").equals("") && count < 5) {number2 += ss[i]; count++;}
                    else break;
                }

                if(Integer.parseInt(number1) == Integer.parseInt(number2)) return 0;

                return Integer.parseInt(number1) - Integer.parseInt(number2);
            }
        });
        return files;
    }
    public static void main(String[] args) {
        String[] file1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] file2 = {"A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"};
        String[] file3 = {"F-15", "f15", "F15.png"};
        
        String[] ans1 = solution(file1);
        for(int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i]+" ");
        }
        System.out.println();
        String[] ans2 = solution(file2);
        for(int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i]+" ");
        }
        System.out.println();
        String[] ans3 = solution(file3);
        for(int i = 0; i < ans3.length; i++) {
            System.out.print(ans3[i]+" ");
        }
    }
}
