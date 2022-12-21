// h e l l o 원래
// o h e l l 한번 
// l o h e l 두번
// l l o h e 세번
// e l l o h 네번(돌아옴)
// 계속 주어진 배열을 1씩 오른쪽으로 밀어서 비교

class Solution {
    public int solution(String A, String B) {
        String a = A;
        int count = 0;
        for(int i = 0; i < A.length(); i++) {
            if(a.equals(B)) return count;
            String a1 = a.substring(a.length()-1);
            a = a1 + a.substring(0, a.length()-1);
            count++;
        }
        return -1;
    }
}


//쌈박한 풀이
// String answer = B+B;
// return answer.indexOf(A);