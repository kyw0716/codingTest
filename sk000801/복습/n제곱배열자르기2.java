package sk000801.복습;

//14분
public class n제곱배열자르기2 {
    public static int[] solution(int n, long left, long right) {
        int len = (int)(right-left);
        int[] ans = new int[len+1];
        for(int i = 0; i <= len; i++) {
            ans[i] = Math.max((int)((left+i)/n), (int)((left+i)%n))+1;
        }
        return ans;
    }
    public static void main(String[] args) {
        int n1 = 3; long left1 = 2; long right1 = 5;
        int n2 = 4; long left2 = 7; long right2 = 14;
        int[] res = solution(n2, left2, right2);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
