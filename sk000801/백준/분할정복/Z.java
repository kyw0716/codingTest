package sk000801.백준.분할정복;
import java.io.*;
import java.util.*;

//분할정복2(?)
//https://www.acmicpc.net/problem/1074
//입력받은 행과 열이 몇 사분면에 존재하는지 알기만 하면 됨
public class Z {
    static int n, r, c;
    static int count = 0;
    public static void divide(int size, int x, int y) {
        if(size == 1) return;

        if(x<size/2 && y<size/2) divide(size/2, x, y); //1사분면
        else if(x<size/2 && y>=size/2) { //2사분면
            count += size*size/4;
            divide(size/2, x, y-size/2);
        }
        else if(x>=size/2 && y<size/2) { //3사분면
            count += (size*size/4)*2;
            divide(size/2, x-size/2, y);
        }
        else { //4사분면
            count += (size*size/4)*3;
            divide(size/2, x-size/2, y-size/2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, n);

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        divide(size, r, c);

        System.out.println(count);
    }
}
