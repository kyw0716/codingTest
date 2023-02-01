package sk000801.백준.백트래킹;
import java.util.*;

//https://www.acmicpc.net/problem/9663
//백트래킹 알고리즘 = 해를 찾을 때 해가 아니라면 되돌아가서 다시 해를 찾는 알고리즘
//보통은 상태를 트리 형태로 나타낼 수 있을 때 사용하기 좋음
//한 줄당 퀸이 하나씩만 들어갈 수 있다는 점을 생각해보기
public class NQueen {
    static int[] queen;
    static int n;
    static int ans = 0;
    public static void pos(int depth) {
        if(depth==n) {
            ans++;
            return;
        }

        for(int i = 0; i < n; i++) {
            queen[depth] = i;

            if(rightPosition(depth)) {
                pos(depth+1);
            }
        }
    }
    public static boolean rightPosition(int depth) {
        for(int i = 0; i < depth; i++) {
            //같은 행에 존재할 때
            if(queen[depth] == queen[i]) return false;
            //열과 행 차가 같을 때 대각선에 놓인 경우
            else if(Math.abs(depth-i) == Math.abs(queen[depth]-queen[i])) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        queen = new int[n];
        //배열의 인덱스가 열, 인덱스의 값이 행

        pos(0);

        System.out.println(ans);
    }
}
