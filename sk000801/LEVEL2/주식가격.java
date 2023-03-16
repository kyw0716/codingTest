package sk000801.LEVEL2;

//https://school.programmers.co.kr/learn/courses/30/lessons/42584
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length-1; i++) {
            boolean all = true;
            for(int j = i+1; j < prices.length; j++) {
                if(prices[i] > prices[j]) {
                    answer[i] = j-i;
                    all = false;
                    break;
                }
            }
            if(all) answer[i] = prices.length-1-i;      
        }
        return answer;
    }
}

//처음에는 무작정 다음 idx일 때 가격이 떨어지지 않는다면 count 해주는 방법으로 생각했는데
//어쨌든 다음 idx에서 가격이 떨어져도 그 사이 1 기간 동안은 유지된 거니까
//떨어진 순간에 둘 시점의 거리?기간?을 배열의 값으로 넣어주었다
//마지막은 주어진 테케의 첫번째 인덱스처럼 아예 하락세가 없을 때는 끝과 주어진 인덱스 사이의 거리를 담아야 하므로
//왜 스택/큐인지는 찾아봐야 할 거 같다

