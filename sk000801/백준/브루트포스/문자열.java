import java.util.*;

public class 문자열 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String a = in.next();
        String b = in.next();

        if(a.length() == b.length()) {
            int count = 0;
            for(int i = 0; i < a.length(); i++) {
                if(a.charAt(i) != b.charAt(i)) count++;
            }
            System.out.println(count);
            return;
        } else {
            int min = Integer.MAX_VALUE;
            if(b.contains(a)) {System.out.println(0); return;}
            else {
                for(int i = 0; i <= b.length()-a.length(); i++) {
                    int count = 0;
                    for(int j = i; j < i + a.length(); j++) {
                        if(a.charAt(j-i) != b.charAt(j)) count++;
                    }
                    min = Math.min(count, min);
                }
                System.out.println(min);
                return;
            }
        } 
    }
}


//길이가 4고 8이면
// 0~3 1~4 2~5 3~6 4~7을 비교해야됨
