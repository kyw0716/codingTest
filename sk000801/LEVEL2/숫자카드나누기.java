package sk000801.LEVEL2;

//11분컷!!
//물론 최대공약수를 간단히 구하는 공식을 참고하긴 했쥐만,,
//만약 최소공배수라면 두 개의 값을 곱한뒤 최대공약수로 나눠줌
public class 숫자카드나누기 {
    public static int getGcd(int a, int b) {
        if(a%b==0) return b;
        return getGcd(b, a%b);
    }
    public static int gcd(int[] arr) {
        if(arr.length == 1) return arr[0];
        int val = getGcd(arr[0], arr[1]);
        
        for(int i = 2; i < arr.length; i++) {
            val = getGcd(val, arr[i]);
        }
        return val;
    }
    public static int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcd1 = gcd(arrayA);
        int gcd2 = gcd(arrayB);
        for(int i = 0; i < arrayA.length; i++) {
            if(arrayA[i] % gcd2 == 0) {
                answer = 0;
                break;
            }
            if(i == arrayA.length-1) answer = gcd2;
        }
        for(int i = 0; i < arrayB.length; i++) {
            if(arrayB[i] % gcd1 == 0) {
                return answer;
            }
        }
        answer = Math.max(gcd2, gcd1);
        return answer;
    }
}
