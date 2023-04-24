package sk000801.복습;

//9분
//기울기를 활용해서 그 아래의 칸 수를 세는 것 까지는 기억이 나는데
//문제는 형변환이 일어나면서 값이 살짝씩 달라지는 것이다
//나는 기울기를 미리 구하고 x값을 곱해주었는데
//기울기 = 높이/가로길이 , 높이*x값/가로길이로 곱할 수들을 먼저 곱한다는 것,,
public class 멀쩡한사각형 {
    public static long solution(int w, int h) {
        long answer = 0;
        //double decline = (double) h/w;
        for(int i = 1; i < w; i++) {
            answer += Math.floor((double)h*i/w);
            //System.out.println((double)decline*i);
        }
        return answer*2;
    }
    public static void main(String[] args) {
        int w = 8; int h = 12;
        System.out.println(solution(w, h));
    }
}
