import java.util.*;

public class 주사위 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> num = new HashMap<Integer, Integer>();

        int S1 = in.nextInt();
        int S2 = in.nextInt();
        int S3 = in.nextInt();

        for(int i = 1; i <= S1; i++) {
            for(int j = 1; j <= S2; j++) {
                for(int p = 1; p <= S3; p++) {
                    if(!num.keySet().contains(i+j+p)) {
                        num.put(i+j+p, 0);
                    } else {
                        num.put(i+j+p, num.get(i+j+p)+1);
                    }
                }
            }
        }

        int max = 0;

        for(int i = 3; i <= S1+S2+S3; i++) {
            max = Math.max(max, num.get(i));
        }

        for(Integer n : num.keySet()) {
            if(num.get(n) == max) {
                System.out.println(n);
                break;
            }
        }

    }
}
