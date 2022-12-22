import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println(solution(in.nextInt()));
        in.close();
    }
    
    public static int solution(int N) {
        int count = 0;
        if(N<=99) return N;
        else {
            count += 99;
            for(int i = 100; i <= N; i++) {
                if((i/100-(i/10)%10) == ((i/10)%10-i%10)) count++; 
            }
        }
        return count;
    }
}

