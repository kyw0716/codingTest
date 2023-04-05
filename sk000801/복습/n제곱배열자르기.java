package sk000801.복습;

//10분
public class n제곱배열자르기 {
    public static int[] solution(int n, int left, int right) {
        int[] answer = new int[right-left+1];
        for(int i = 0; i < answer.length; i++) {
            //(left/n, left%n)이 원래 2차원 배열의 좌표..
            //근데 여기서 1부터 값이 시작하므로 1씩 더해줌
            int x = left/n+1;
            int y = left%n+1;
            left++;
            answer[i] = Math.max(x, y);
            System.out.print(answer[i]+" ");
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(4, 7, 14));
    }
}

