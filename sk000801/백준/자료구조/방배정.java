import java.io.*;
public class 방배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] one = br.readLine().split(" ");
        int num = Integer.parseInt(one[0]);
        int limit = Integer.parseInt(one[1]);

        //여자 0, 남자 1로 받아오는 값 구분
        int[] girl = new int[6];
        int[] boy = new int[6];
        int answer = 0;

        for(int i = 0; i < num; i++) {
            String[] two = br.readLine().split(" ");
            if(Integer.parseInt(two[0]) == 0) {
                girl[Integer.parseInt(two[1])-1]++;
            } else {
                boy[Integer.parseInt(two[1])-1]++;
            }
        }

        for(int i = 0; i < 6; i++) {
            if(girl[i]%limit == 0) answer += girl[i]/limit;
            else answer += (girl[i]/limit)+1;
        }

        for(int i = 0; i < 6; i++) {
            if(boy[i]%limit == 0) answer += boy[i]/limit;
            else answer += (boy[i]/limit)+1;
        }

        System.out.println(answer);
    }
}
