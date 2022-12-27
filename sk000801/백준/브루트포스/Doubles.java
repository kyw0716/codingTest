import java.util.*;

public class Doubles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();

        for(;;) {
            int a = in.nextInt();
            if(a != 0 && a != -1) {
                nums.add(a);
            }
            if(a == 0) {
                int count = 0;
                for(int i = 0; i < nums.size(); i++) {
                    if(nums.contains(nums.get(i)*2)) count++;
                }
                System.out.println(count);
                nums.clear();
            }
            if(a==-1) break;
        }
    }
}

//입력이 0이면 리스트 문을 닫고,
//입력이 -1이면 입력을 더 이상 받지 않음
