package sk000801.복습;

//25분
public class 당구연습 {
    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        //각 축 x = 0, x = m, y = 0. y = n 기준으로 대칭이동한 좌표
        int[][] value = {{-startX, startY}, {startX, -startY}, {2*m-startX, startY}, {startX, 2*n-startY}};
    
        for(int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            //아래 네가지는 그림을 그려보면 캐치가 가능하다
            //위, 아래 x값 가만히
            int top = (int)Math.pow(value[3][0]-balls[i][0], 2)+(int)Math.pow(value[3][1]-balls[i][1], 2);
            int down = (int)Math.pow(value[1][0]-balls[i][0], 2)+(int)Math.pow(value[1][1]-balls[i][1], 2);
            //왼, 오른쪽 y값 가만히
            int left = (int)Math.pow(value[0][0]-balls[i][0], 2)+(int)Math.pow(value[0][1]- balls[i][1], 2);
            int right = (int)Math.pow(value[2][0]-balls[i][0], 2)+(int)Math.pow(value[2][1]-balls[i][1], 2);
            
            if(startX == balls[i][0] && startY < balls[i][1]) { //up 빼고
                min = Math.min(min, down);
                min = Math.min(Math.min(right, left), min);
            } else if(startX == balls[i][0] && startY > balls[i][1]) { //down 빼고
                min = Math.min(min, top);
                min = Math.min(Math.min(right, left), min);
            } else if(startY == balls[i][1] && startX < balls[i][0]) { //right빼고
                min = Math.min(min, left);
                min = Math.min(Math.min(top, down), min);
            } else if(startY == balls[i][1] && startX > balls[i][0]) { //left 빼고
                min = Math.min(min, right);
                min = Math.min(Math.min(top, down), min);
            } else {
                min = Math.min(Math.min(top, down), min);
                min = Math.min(Math.min(left, right), min);
            }

            answer[i] = min;
        }

        return answer;
    }
    public static void main(String[] args) {
        int[][] balls = {{7,7}, {2,7}, {7,3}};
        int[] res = solution(10, 10, 3, 7, balls);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
