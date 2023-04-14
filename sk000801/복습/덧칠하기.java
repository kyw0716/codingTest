package sk000801.복습;

//11분
//혼자 수를 써서 풀어보려 했으나,, fail,,,
//그냥 정공법으로 쭉 for문을 통해 훑어야함..
public class 덧칠하기 {
    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int temp = section[0]+m-1;
        for(int i = 1; i < section.length; i++) {
            if(temp < section[i]) {
                answer++;
                temp = section[i]+m-1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n1 = 8; int m1 = 4; int[] section1 = {2,3,6};
        int n2 = 5; int m2 = 4; int[] section2 = {1,3};
        int n3 = 4; int m3 = 1; int[] section3 = {1,2,3,4};
        System.out.println(solution(n1, m1, section1));
        System.out.println(solution(n2, m2, section2));
        System.out.println(solution(n3, m3, section3));
    }
}
