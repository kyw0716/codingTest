package sk000801.백준.그리디;
import java.io.*;

public class 신입사원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++) {
            int answer = 1;
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n+1]; //1~n까지의 지원자 값을 담을 인덱스

            for(int j = 0; j < n; j++) {
                String[] s = br.readLine().split(" ");
                rank[Integer.parseInt(s[0])]= Integer.parseInt(s[1]);
                //인덱스는 서류 순위, 값은 면접 순위
            }

            int min = rank[1];
            //min은 서류순위가 1일때의 면접 순위!

            for(int j = 2; j <= n; j++) {
                //(이게 서류 성적대로 그 면접 순위를 비교히는것)
                if(rank[j]< min) {
                    //만약 면접순위가 서류순위1일때의 면접순위보다 작다면
                    min = rank[j]; //최소값을 바꿔줌, 원래의 min값을 갖는 인덱스는 둘 다 크니까
                    answer++; //답에 추가
                }
            }
            

            // for(int p = 0; p < n; p++) {
            //     for(int r = 0; r < n; r++) {
            //         if(p==r) continue;
            //         if(rank[p][0] > rank[r][0] && rank[p][1] > rank[r][1]) break;
            //         //p의 두 등수가 모두 r의 등수보다 낮을 때
            //         if(r==n-1) answer++;
            //     }   
            // }
            //이건 나의 초기 생각이나 틀리기도 했고, 어차피 시간 복잡도에서 걸림

            System.out.println(answer);
        }
    }
}
