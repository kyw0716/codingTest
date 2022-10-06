import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> A1 = new ArrayList<>();
        ArrayList<Integer> B1 = new ArrayList<>();
        for(int i=0; i<A.length; i++) {
            A1.add(A[i]);
            B1.add(B[i]);
        }
        int answer = 0;
        for(int i=0; i<A.length; i++) {
            if(A1.get(0) >= B1.get(0)) {
                answer += A1.get(0)*B1.get(B1.size()-1);
                A1.remove(0);
                B1.remove(B1.size()-1);
            }
            else {
                answer += B1.get(0)*A1.get(A1.size()-1);
                B1.remove(0);
                A1.remove(A1.size()-1);
            }
        }


        return answer;
    }
}