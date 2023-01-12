package sk000801.백준.그리디;
import java.util.*;

public class 카드정렬하기 {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = in.nextInt();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            pq.add(in.nextInt());
        }

        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();

            answer += a+b;
            pq.add(a+b);
        }

        System.out.println(answer);
    }
}

//사실 우선순위 큐를 넣는것이 매우 아주 좋다고 함...

// int n = in.nextInt();
// long[] nums = new long[n];
// List<Long> answer = new ArrayList<>();
// long real = 0;

// for(int i = 0; i < n; i++) {
//     nums[i] = in.nextInt();
// }
// Arrays.sort(nums);

// if(n==1) {System.out.println(0); return;}

// answer.add(nums[0]+nums[1]);
// if(n==2) {System.out.println(answer.get(0)); return;}

// for(int i = 2; i < n-1; i++) {
//     long a = answer.get(answer.size()-1)+nums[i];
//     long b = nums[i]+nums[i+1];
//     if(a >= b) {
//         answer.add(a);
//     } else {
//         answer.add(b);
//         // i++;
//     }
// }

// for(int i = 0; i < answer.size(); i++) {
//     real += answer.get(i);
// }

// System.out.println(real);