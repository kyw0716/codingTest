package sk000801.LEVEL3;
//31분
//시간 복잡도가 ~~억 단위로 넘어간다면 이분 탐색을 의심해볼 것
public class 징검다리건너기 {
    public boolean check(int mid, int[] stones, int k) {
        int count = 0;
        int res = 0;
        
        for(int i = 0; i < stones.length; i++) {
            if(stones[i] < mid) count++;
            else {
                if (count > res) res = count;
                count = 0;
            }
            if(i == stones.length-1) {
                if (count > res) res = count;
            }
        }
        
        return res >= k;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int min = 1;
        int max = 0;
        for(int i = 0; i < stones.length; i++) {
            max = Math.max(max, stones[i]);
        }

        while(min <= max) {
            int mid = (min+max)/2;
            if(check(mid, stones, k)) {
                max = mid-1;
            } else {
                answer = mid;
                min = mid+1;
            }
        }
        
        return answer;
    }
}

// 효율성 전혀 고려하지 않은 풀이
// public boolean cross(int[] stones, int k) {
//         int first = 0;
//         for(int i = 0; i < stones.length; i++) {
//             if(i-first > k) return false;
//             if(stones[i] == 0) continue;
//             else {
//                 stones[i]--;
//                 first = i;
//             }
//         }
//         return true;
//     }
// public int solution(int[] stones, int k) {
//         int answer = 0;
//         if(stones.length == 1) return stones[0];
//         while(true) {
//             if(cross(stones, k)) answer++;
//             else break;
//         }
//         return answer;
// }
