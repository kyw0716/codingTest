package sk000801.LEVEL3;

//이눔의 효율성 2번.. 
//51분 잡아먹힘,, 애초에 가장 긴 길이부터 탐색할 girl ㅠㅠ
//https://algorithm-master.tistory.com/m/114 결국에는 이분 풀이를 참조했다.. 반성해 이자식
//https://school.programmers.co.kr/learn/courses/30/lessons/12904
//dp로 풀었다가 아닌 거 같아서 좌우 인덱스 탐색으로 풀었다가
//결국 전체탐색으로 풀어냈다(그러나 O(n^3)이라 좌우 인덱스 탐색이 시간 복잡도에서 더 좋다구 하더라)
public class 가장긴팰린드롬 {
    public int solution(String s) {
        int n = s.length();
        int answer = 1;
        char[] arr = s.toCharArray();
        
        for (int i = n; i > 1; i--) {
            for (int j = 0; j <= n - i; j++) {
                boolean check = true;
                for (int k = 0; k < i / 2; k++) {
                    if (arr[k + j] != arr[j + i - 1 - k]) {
                        check = false;
                        break;
                    }
                }
                if (check) return i;
            }
        }
        
        return answer;
    } 
}

    // 그냥 처음부터 탐색한 풀이
    // public int solution(String s) {
    //     int n = s.length();
    //     int answer = 1;
    //     char[] arr = s.toCharArray();
        
    //     if(s.length() == 1) return 1;
        
    //     for(int i = 0; i < n; i++) {
    //         for(int j = i+1; j < n; j++) {
    //             boolean check = false;
    //             for(int r = 0; r <= (j-i)/2; r++) {
    //                 if(arr[i+r] != arr[j-r]) break;
    //                 if(r == (j-i)/2) check = true;
    //             }
    //             if(check && answer < j-i+1) answer = j-i+1; 
    //             if(answer == n) return n;
    //         }
    //     }
        
    //     return answer;
    // } 
