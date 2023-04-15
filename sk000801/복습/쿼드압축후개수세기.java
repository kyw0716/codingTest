package sk000801.복습;

//static 문제 때문에 값이 제대로 안나온듯,,,
//하나씩 테케 돌려보니까 값이 잘 나온다!
//17분
public class 쿼드압축후개수세기 {
    static int[] ans = new int[2];
    public static void quad(int x, int y, int n, int[][] arr) {
        int val = arr[x][y];

        int count = 0;
        for(int i = x; i < x+n; i++) {
            for(int j = y; j < y+n; j++) {
                if(val == arr[i][j]) count++;
            }
        }
        if(count == n*n) {
            if(val == 0) ans[0]++;
            else ans[1]++;
            return;
        }

        quad(x, y, n/2, arr);
        quad(x+n/2, y, n/2, arr);
        quad(x, y+n/2, n/2, arr);
        quad(x+n/2, y+n/2, n/2, arr);
    }
    public static int[] solution(int[][] arr) {
        int n = arr.length;

        quad(0, 0, n, arr);

        return ans;
    }
    public static void main(String[] args) {
        // int[][] arr1 = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        // int[] ans1 = solution(arr1);
        // System.out.println(ans1[0]+" "+ans1[1]);
        
        int[][] arr2 = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1},{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};
        int[] ans2 = solution(arr2);
        System.out.println(ans2[0]+" "+ans2[1]);
    }
}
