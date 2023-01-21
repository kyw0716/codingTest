package sk000801.백준.브루트포스;
import java.util.*;

public class 감소하는수 {
    static List<Long> list = new ArrayList<>();
    public static void dfs(long num, int i) {
        //i가 depth인가봄
        //num이 1 -> 1, 10
        //num이 2 -> 2, 21, 20, 210 
        //요런식으로 9까지 돔
        if(i>10) return;
        
        list.add(num);
        for(int j = 0; j < num%10; j++) {
            dfs((num*10)+j, j+1);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        if(n<=10) {System.out.println(n); return;}
        else if(n>=1023) {System.out.println(-1); return;}

        for(int i = 0; i <= 9; i++) {
            dfs(i,1);
        }

        list.sort(Comparator.naturalOrder());
        System.out.println(list.get(n));
    }
}


        //런타임 에러 나는 코드
        // int index = 9;
        // int num = 10;

        // if(n<=9) {System.out.println(n); return;}
        // while(index < n) {
        //     if(n>1022) {System.out.println(-1);return;}
        //     String[] s = String.valueOf(num).split("");
        //     for(int i = 0; i < s.length-1; i++) {
        //         if(Integer.parseInt(s[i]) <= Integer.parseInt(s[i+1])) break;
        //         if(i == s.length-2) index++;
        //     }
        //     num++;
        // }

        // System.out.println(num-1);
