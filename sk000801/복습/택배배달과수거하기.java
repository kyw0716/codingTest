package sk000801.복습;

public class 택배배달과수거하기 {
    //deliveries는 배달할 택배 상자 pickups는 수거할 빈 재활용 상자
    //cap은 트럭에 수용할 수 있는 상자 개수
    //23분 바보같은 실수..
    //배달물과 수거물을 별개로 생각!
    //그렇지만 둘 중 하나라도 뺐을 때 음수라면 어차피 왔다갔다 해야하니까
    //count해줘야됨
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        long del = 0;
        long pick = 0;

        for(int i = n; i >= 1; i--) {
            int count = 0;
            del -= deliveries[i-1];
            pick -= pickups[i-1];

            while(del < 0 || pick < 0) {
                del += cap;
                pick += cap;
                count++;
            } 

            answer += 2*count*i;
        }

        return answer;
    }   
    public static void main(String[] args) {
        int cap1 = 4; int n1 = 5; int[] deliveries = {1,0,3,1,2}; int[] pickups = {0,3,0,4,0};
        int cap2 = 2; int n2 = 7; int[] deliveries2 = {1,0,2,0,1,0,2}; int[] pickups2 = {0,2,0,1,0,2,0};
        System.out.println(solution(cap2, n2, deliveries2, pickups2));
    }
}