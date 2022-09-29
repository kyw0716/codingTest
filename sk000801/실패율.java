import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class Solution {
   
    public int[] solution(int N, int[] stages) {
        double[] failure = new double[N];
        Map<Integer, Double> index = new HashMap<>();
        int[] answer = new int[N];
        for(int i=1; i<=N; i++) {
            answer[i-1] = i;
            int count = i;
            double bunja =  Arrays.stream(stages).filter(
            s -> s == count).count();
            double bunmo =  Arrays.stream(stages).filter(
            s -> s >= count).count();
            if(bunja == 0) {failure[i-1] = 0;}
            else {failure[i-1] = bunja/bunmo;}  
            index.put(i, failure[i-1]);
        }
        
        for(int i=N-1;i>=1;i--){
            for(int j=N-1;j>=(N-i);j--){
                if( failure[j-1]<failure[j] ){
                    double temp=failure[j-1];
                    failure[j-1]=failure[j];
                    failure[j]=temp;
                    int temp2=answer[j-1];
                    answer[j-1]=answer[j];
                    answer[j]=temp2;
                }
            }
        }        
        return answer;
    }
}