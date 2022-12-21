//일단 최대공약수 구하기
//최대공약수를 분모와 나누기
//2,5로 나눠서 1이 되면 유한, 안되면 무한 (애초에 1이면 정수이므로 가눙)
class Solution {
    public int solution(int a, int b) {
        int max = 0; //최대 공약수
		for(int i=1; i<=a && i<=b; i++) {
			if(a%i==0 && b%i==0) {
				max = i;
			}
		}
        b /= max;
        while(b%2==0) {b/=2;}
        while(b%5==0) {b/=5;}
        return b == 1 ?  1 :  2;
    }
}