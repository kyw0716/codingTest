package sk000801.복습;

//22분인데 이게 맞을까ㅠㅠㅠㅜ
//아 이게 짝수일 때는 1을 더한게 답이고
//7 = 0111(2) 11 = 1011(2)
public class two개이하로다른비트 {
    public static long change(long a) {
        String s = Long.toBinaryString(a);
        StringBuffer ss = new StringBuffer("");
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                ss.append(s.substring(0, i)).append("10").append(s.substring(i+2, s.length()));
            }
        }
        if(s.lastIndexOf('0') == -1) ss.append("10").append(s.substring(1, s.length()));
        return Long.parseLong(ss.toString(), 2);
        //2진수를 10진수로 바꾸는 방법
    }
    public static long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==0) {
                ans[i] = numbers[i]+1;
            } else {
                ans[i] = change(numbers[i]);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        long[] ans = solution(numbers);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
