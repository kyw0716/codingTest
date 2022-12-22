import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println(solution(in.nextInt()));
        in.close();
    }
    
    public static int solution(int N) {
        for(int i = 1; i < N; i++) {
            int number = i;
            String[] hap = String.valueOf(i).split("");
            for(int j = 0; j < hap.length; j++) {
                number += Integer.parseInt(hap[j]);
            }
            if(number == N) return i;
        }
        return 0;
    }
}

