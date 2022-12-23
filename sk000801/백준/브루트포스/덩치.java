import java.util.Scanner;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
 
		int N = in.nextInt();
 
		int[][] arr = new int[N][2];
 
		for(int i = 0; i < N; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt(); 
		}

        int[] rank = new int[N];

        for(int i = 0; i < N; i++) {
			int[] spec = {arr[i][0], arr[i][1]};
            for(int j = i+1; j < N; j++) {
                if(spec[0]<arr[j][0] && spec[1]<arr[j][1]) {
					rank[i]++;
				}
            }
			if(i>0) {
				for(int p = 0; p < i; p++) {
					if(spec[0]<arr[p][0] && spec[1]<arr[p][1]) {
						rank[i]++;
					}
				}
			}
			rank[i]++;
        }

		for(int i = 0; i < N; i++) {
			System.out.print(rank[i] + " ");
		}
    }
}

// 자신보다 덩치가 더 큰 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
// count를 통해 등수 결정?