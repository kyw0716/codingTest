package sk000801.LEVEL2;
//처음보는 비트 연산
//걸린 시간 47분.. 시간 초과 포함!
//짝수는 2진수로 변환했을 때 1 자릿수가 0이라서 다음 수가 최솟값
//홀수는 작은 자릿수부터 시작해 처음으로 0이 오는 자리를 1로 바꿔주고 그 오른쪽 값을 0으로 넣어주면 됨
//만약 모든 자릿수 값이 0이라면 앞부분에 10을 채워주고 남은 수들을 다시 넣어주면 됨
class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i]%2==0) answer[i] = numbers[i]+1;
            else {
                String num = Long.toBinaryString(numbers[i]);
                int idx = num.lastIndexOf("0");
                if(idx != -1) {
                    num = num.substring(0, idx)+"10"+num.substring(idx+2, num.length());
                    answer[i] = Long.parseLong(num, 2);
                } else {
                    num = "10"+num.substring(1, num.length());
                    answer[i] = Long.parseLong(num, 2);
                }
            }
        }
        
        return answer;
    }
}


// class Solution {
//     public long count(long num1, long num2) {
//         long count = 0;
//         String n1 = Long.toBinaryString(num1);
//         String n2 = Long.toBinaryString(num2);
//         String plus = "";
//         if(n1.length() != n2.length()) {
//             for(int i = 0; i < n2.length()-n1.length(); i++) {
//                 plus += "0";
//             }
//         }
//         plus += n1;
//         for(int i = 0; i < n2.length(); i++) {
//             if(plus.charAt(i) != n2.charAt(i)) count++;
//         }
//         return count;
//     }
//     public long[] solution(long[] numbers) {
//         long[] answer = new long[numbers.length];
//         for(int i = 0; i < numbers.length; i++) {
//             long num = numbers[i]+1;
//             while(true) {
//                 if(count(numbers[i], num) <= 2) {
//                     answer[i] = num;
//                     break;
//                 }
//                 num++;
//             }
//         }
//         return answer;
//     }
// }