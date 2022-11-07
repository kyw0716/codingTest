class Solution {
    public int calLCM(int a, int b) {
        int GCD = 1;
        int multi  = a*b;
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a + " " + b);
        if (a % b == 0) {
            GCD = b;
        } else {
            int c = a % b;
            while (b % c != 0 && c != 0) {
                if (c == 0) {
                    GCD = b;
                    break;
                }
                int temp = b;
                b = c;
                c = temp % c;
            }
            GCD = c;
        }
        return multi/GCD;
    }
    public int solution(int[] arr) {
        int LCM = calLCM(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i++) {
            LCM = calLCM(arr[i], LCM);
        }
        return LCM;
    }
}