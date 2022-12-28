public class 완전_세제곱 {
    public static void main(String[] args) {

        for(int a = 6; a <= 100; a++) {
            for(int b = 2; b <= 99; b++) {
                for(int c = b; c <= 99; c++) {
                    for(int d = c; d <= 99; d++) {
                        if(a*a*a == (b*b*b+c*c*c+d*d*d)) {
                            System.out.println("Cube = " + a + ", Triple = (" + b + "," + c + "," + d + ")");
                        } 
                    }
                }
            }
        }
    }
}
