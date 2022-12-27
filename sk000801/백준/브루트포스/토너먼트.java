import java.util.*;

public class 토너먼트 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int kim = in.nextInt();
        int lim = in.nextInt();
        int count = 0;

        while(kim != lim) {
            kim = (kim+1)/2;
            lim = (lim+1)/2;
            count ++;
            n /= 2;        
        }

        System.out.println(count);
    }
}

//다음 경기의 순서는 (원래수+1)/2
// 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//  1   2   3   4   5     6     7     8
//    1       2        3           4
//        1                 2
//                 1
