package sk000801.복습;

public class 조이스틱 {
    public static int solution(String name) {
        int min = 0;
        int idx = 0;
        int move = name.length()-1;

        for(int i = 0; i < name.length(); i++) {
            //상하로 움직이는 부분 더한 부분
            min += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);

            idx = i+1;
            
            //연속되는 A 개수
            while(idx < name.length() && name.charAt(idx) == 'A') idx++;

            //이제부터는 이동수(좌우로)가 적은 방법 찾기
            //순서대로 vs 뒤로 돌아가는 경우 중 최솟값
            move = Math.min(move, name.length()+i*2-idx); 
            //처음부터 뒷부분을 먼저 탐색하는 것이 유리한 경우(?)
            //연속된 A 부분의 앞부분보다 뒷부분이 더 짧은 경우
            move = Math.min(move, 2*(name.length()-idx)+i);
        }
        return min+move;
    }
    public static void main(String[] args) {
        String name1 = "JEROEN"; 
        String name2 = "JAN";
        System.out.println(solution(name1));
    }
}
