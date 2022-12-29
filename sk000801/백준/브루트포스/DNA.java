import java.util.*;

public class DNA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
     
        String[] dna = {"A", "C", "G", "T"};
        
        String[] nums = in.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        String[][] s = new String[n][m];

        String answer  = "";
        int answer2 = 0;

        for(int i = 0; i < n; i++) {
            s[i] = in.nextLine().split("");
        }

        for(int i = 0; i < m; i++) {
            int[] count = new int[4];
            int max = 0;
            for(int j = 0; j < n; j++) { // 첫째 줄, 둘째 줄
                for(int r = 0; r < 4; r++) {
                    if(s[j][i].equals(dna[r])) count[r]++;
                }
            }
            for(int k = 0; k < 4; k++) {
                max = Math.max(max, count[k]);
            }
            for(int p = 0; p < 4; p++) {
                if(max == count[p]) {
                    answer += dna[p];
                    answer2 += n-max;
                    break;}
            }
        }

        System.out.println(answer);
        System.out.println(answer2);
    }
}
