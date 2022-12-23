import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);

        int[] arr = new int[9];
        int hap = 0;
        int[] no = new int[2];
 
		for(int i = 0; i < 9; i++) {
            arr[i] = in.nextInt();
            hap += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < 9; i++) {
            for(int j = i+1; j < 9; j++) {
                if(hap-arr[i]-arr[j] == 100) {
                    no[0] = i;
                    no[1] = j;
                    break;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i != no[0] && i != no[1]) System.out.println(arr[i]);
        }
 
    }
}

// 일단 아홉명을 다 array에 넣어놓고 2개의 난쟁이들 키만 뺀다
// 만약 두개 뺐을 때의 값이 100이라면 그 인덱스를 뽑아냄