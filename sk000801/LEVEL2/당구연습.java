package sk000801.LEVEL2;

class 당구연습 {
    //근데 뭔소린지 당최 모르겠다 최소 70분..
    //선대칭까지는 알겠는디ㅠㅠ
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        //상하좌우 선대칭 좌표값
        int[][] value = {{-startX, startY}, {startX, -startY}, {2*m-startX, startY}, {startX, 2*n-startY}};
        for(int i = 0; i < balls.length; i++) {
            int min = Integer.MAX_VALUE;
            int up = (int)Math.pow(value[3][0]-balls[i][0],2)+(int)Math.pow(value[3][1]-balls[i][1], 2);
            int down = (int)Math.pow(value[1][0]-balls[i][0],2)+(int)Math.pow(value[1][1]-balls[i][1], 2);
            int left = (int)Math.pow(value[0][0]-balls[i][0],2)+(int)Math.pow(value[0][1]-balls[i][1], 2);
            int right = (int)Math.pow(value[2][0]-balls[i][0],2)+(int)Math.pow(value[2][1]-balls[i][1], 2);
            //'상' 점대칭 X
            if(startX == balls[i][0] && balls[i][1] > startY) {
                min = Math.min(min, down);
                min = Math.min(Math.min(right, left), min);
            }
            //'하' 점대칭 X
            else if(startX == balls[i][0] && balls[i][1] < startY) {
                min = Math.min(min, up);
                min = Math.min(Math.min(left, right), min);
            }
            //'우' 점대칭 X
            else if(startY == balls[i][1] && balls[i][0] > startX) {
                min = Math.min(min, up);
                min = Math.min(Math.min(down, left), min);
            } 
            //'좌' 점대칭 X
            else if(startY == balls[i][1] && balls[i][0] < startX) {
                min = Math.min(min, up);
                min = Math.min(Math.min(down, right), min);
            }
            //그냥 다 가능할 경우(x, y값 중 그 어느것도 같지 않을 때)
            else {
                min = Math.min(min, Math.min(up, down));
                min = Math.min(Math.min(left, right), min);
            }
            answer[i] = min;
        }
        return answer;
    }
}
