package sk000801.복습;

//23번 테케에서 걸림.. 
// => 어피치가 10점을 n번 쏜거 외에도, 최댓값이 0일 때 -1을 반환해줘야함!!!
//17분
public class 양궁대회 {
    static int[] lion = new int[11];
    static int[] answer = new int[11];
    static int max = 0;
    public static int getMax(int[] info) {
        int lionScore = 0;
        int apScore = 0;

        for(int i = 0; i < info.length; i++) {
            if(info[i] == 0 && lion[i] == 0) continue;
            
            if(info[i] < lion[i]) lionScore += 10-i;
            else apScore += 10-i;
        }

        return lionScore-apScore;
    }
    public static void perm(int n, int[] info, int depth) {
        if(depth == n) {
            int res = getMax(info);
            if(max <= res) {
                max = res;
                answer = lion.clone();
            }
            return;
        } 

        for(int i = 0; i < info.length; i++) {
            if(lion[i] > info[i]) break;
            lion[i]++;
            perm(n, info, depth+1);
            lion[i]--;
        }
    }
    public static int[] solution(int n, int[] info) {
        if(info[0] == n) return new int[]{-1};

        perm(n, info, 0);
        if(max == 0) return new int[]{-1};

        return answer;
    }
    public static void main(String[] args) {
        int n1 = 5; int[] info1 = {2,1,1,1,0,0,0,0,0,0,0};
        int n2 = 1; int[] info2 = {1,0,0,0,0,0,0,0,0,0,0};
        int n3 = 9; int[] info3 = {0,0,1,2,0,1,1,1,1,1,1};
        int[] res = solution(n3, info3);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
