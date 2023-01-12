package sk000801.백준.그리디;
import java.util.*;

public class 거스름돈 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int geo = 1000-n;
        int answer = 0;


            answer += geo/500; //1
            geo -= (geo/500)*500;
            if(geo <= 0) {System.out.println(answer); return ;}
            answer += geo/100; //1
            geo -= (geo/100)*100;
            if(geo <= 0) {System.out.println(answer); return ;}
            answer += geo/50; //0
            geo -= (geo/50)*50;
            if(geo <= 0) {System.out.println(answer); return ;}
            answer += geo/10; //2
            geo -= (geo/10)*10;
            if(geo <= 0) {System.out.println(answer); return ;}
            answer += geo/5;
            geo -= (geo/5)*5;
            if(geo <= 0) {System.out.println(answer); return ;}
            answer += geo;
            geo -= geo;

        System.out.println(answer);
    }
}
