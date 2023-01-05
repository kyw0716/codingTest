package sk000801.백준.수학;
import java.io.*;

public class 캠핑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 1;
        for(;;) {
            String[] s = br.readLine().split(" ");
            if(s[0].equals("0") && s[1].equals("0") && s[2].equals("0")) {
                break;
            } else {
                int limit = Integer.parseInt(s[0]);
                int days = Integer.parseInt(s[1]);
                int all = Integer.parseInt(s[2]);

                int answer = (all/days)*limit;
                answer += all%days<limit ? all%days : limit;

                System.out.println("Case "+ i +": "+ answer);
                i++;
            }
        }
    }
    
}
