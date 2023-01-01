import java.io.*;
public class 팰린드롬만들기 {
    public static boolean check(int left, int right, char[] arr) {
        while(left < right) {
            if(arr[left] != arr[right]) break;
            left++;
            right--;
        }
        if(left >= right) return true;
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int count = 0;
        int left = 0;

        for(;;) {
            if(check(left, s.length()-1, s.toCharArray())) {
                count = left+s.length();
                break;
            }
            left++;
        }

        System.out.println(count);
    }
}
