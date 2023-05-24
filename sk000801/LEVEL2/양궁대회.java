package sk000801.LEVEL2;

//라이언이 가장 큰 점수차로 우승(가장 낮은 점수 더 많이 맞힌 경우)
//10!을 그냥 순열로 돌려도 안되겠구나,, 헐랭
//11개의 배열을 boolean으로 받아서 최대 차이를 구하는게 나을듯
//힌트 보니 가장 낮은 점수를 포함하고 있어야 된다고 하는데 얘를 아예 true로 바꿔버려야 해..?
//풀이를 보니 원래대로 백트래킹..? 으로 푸는게 맞았던듯 헐랭
//풀이에 그 백트래킹 도는 for문에 조건을 두는 걸 고려 안하고 돌려서 아마도 처음에 잘 안됐던듯
//그리고 이 풀이는 처음부터 10점부터 시작되는 배열이므로 자연스럽게 마지막에 만족하는 최댓값이
//가장 낮은 점수를 맞힌 개수가 높을 때임!! 자연스럽게 백트래킹 돌면 돼
//42분!!

class 양궁대회 {
    int[] lion = new int[11];
    int[] answer = {-1};
    int max = 0;
    public int getMax(int[] info) {
        int lions = 0;
        int apeach = 0;
        for(int i = 0; i < info.length; i++) {
            if(info[i] == 0 && lion[i] == 0) continue;
            if(lion[i] > info[i]) lions += 10-i;
            else apeach += 10-i;
        }
        return lions-apeach;
    }
    public void recur(int n, int[] info, int depth) {
        if(depth == n) {
            int val = getMax(info);
            if(max <= val) {
                max = val;
                answer = lion.clone();
            }
            return;
        }
        
        for(int i = 0; i < info.length && lion[i] <= info[i]; i++) {
            if(lion[i] > info[i]) break;
            lion[i]++;
            recur(n, info, depth+1);
            lion[i]--;
        }
    }
    public int[] solution(int n, int[] info) {
        recur(n, info, 0);
        //진심 궁금하다 answer의 기본값을 -1로 뒀는데 max == 0일때 왜 
        if(max == 0) return new int[]{-1};
        return answer;
    }
}
