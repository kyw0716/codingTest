package sk000801.백준.복습;
import java.io.*;
import java.util.*;

//처음에 더하기만 했던 비슷한 문제는 우선순위 큐로 풀어서 얘도 그렇게 풀어야 하나 했는데
//생각보다 예외사항이 굉장히 많아서 1을 기점으로 1보다 작은 값만 모은 리스트,
//1보다 큰 값만 모은 리스트를 나눠 각자 계산해주어 합계를 내었다
public class 수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();

        while(n-->0) {
            int a = Integer.parseInt(br.readLine());
            if(a<1) small.add(a);
            else big.add(a);
        }
        small.sort(Comparator.naturalOrder());
        big.sort(Comparator.reverseOrder());

        int answer = 0;

        int idx1 = 0;
        while(idx1 <= big.size()-1) {
            if(idx1+1 < big.size() && big.get(idx1) != 1 && big.get(idx1+1) != 1) answer += big.get(idx1++)*big.get(idx1++);
            else answer += big.get(idx1++);
        }

        int idx2 = 0;
        while(idx2 <= small.size()-1) {
            if(idx2+1 < small.size()) answer += small.get(idx2++)*small.get(idx2++);
            else answer += small.get(idx2++);
        }

        System.out.println(answer);
    }
}
