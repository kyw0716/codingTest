package sk000801.LEVEL2;

//투 포인터임을 잊지 말.
//31분+풀이 참조 거의 10분 15분 한듯
//마지막에 뭐가 자꾸 인덱스 범위를 벗어났다구 해서
import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int right = 0;
        int left = 0;
        int temp = sequence[0];
        List<int[]> list = new ArrayList<>();
        
        while(right <= left) {
            if(temp == k) {
                list.add(new int[]{right, left});
            }
            
            if(right == sequence.length-1 && left == sequence.length-1) break;
            
            if(temp < k && left < sequence.length) {
                //도대체 오른쪽의 left범위가 무엇에 영향을 미치는 걸까,,,
                //얘를 해줘야 하는 이유는 몰카
                left++;
                if(left < sequence.length) temp += sequence[left];
            } else {
                if(right < sequence.length) temp -= sequence[right];
                right++;
            } 
        }        
        
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(Math.abs(a[0]-a[1]) == Math.abs(b[0]-b[1])) return a[0]-b[0];
                return Math.abs(a[0]-a[1])-Math.abs(b[0]-b[1]);
            }
        });
        return list.get(0);
    }
}
