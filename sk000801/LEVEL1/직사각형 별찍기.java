import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i=0; i<b; i++) {
            String a1 = "";
            for(int j=0; j<a; j++) {
               a1 += "*";
            }
            System.out.println(a1);
        }
    }
}