package sk000801.복습;

public class 주식가격 {
    //7분!!!
    //스택, 큐 문제라고 했는데 마땅히 생각이 안나서 2중 for문으로 문제 풀이함
    //스택, 큐로 어떻게 푸는지 알아보도록!!
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length-1; i++) {
            boolean check = true;
            int num = prices[i];
            for(int j = i+1; j < prices.length; j++) {
                if(num > prices[j]) check = false;
                if(!check) {
                    answer[i] = j-i;
                    break;
                }
                if(j == prices.length-1) answer[i] = j-i; 
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution(prices);
        for(int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }   
}

// 아래는 스택 문제 풀이를 가져옴(https://girawhale.tistory.com/7)
// 스택에 인덱스 값을 넣어주어
// 현재 인덱스의 주식 값보다 스택의 상위 인덱스의 주식 값이 더 크다면 
// 값이 하락세이기 때문에 pop해준 후 정답배열에 그 시간을 넣어준다.
// 그 후 비교해준 현재 인덱스를 스택에 넣어준다.
// public int[] solution(int[] prices) {
//     int[] ans = new int[prices.length];
//     Stack<Integer> stack = new Stack();

//     for (int i = 0; i < prices.length; i++) {
//         while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
//             ans[stack.peek()] = i - stack.peek();
//             stack.pop(); 
//         stack.push(i);
//     }
//     while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
//         ans[stack.peek()] = prices.length - stack.peek() - 1;
//         stack.pop();
//     }

//     return ans;
// }


