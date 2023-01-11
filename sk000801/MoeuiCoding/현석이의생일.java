package sk000801.MoeuiCoding;
import java.util.*;
import java.math.BigInteger;

public class 현석이의생일 {
    static BigInteger bi;
    static int a;
    static int b;
    static boolean[] visited;
    static List<Integer> bigIdx;
 
    public static void main(String[] args){
      Scanner in = new Scanner(System.in);
        
        StringBuilder sb = new StringBuilder("");
        int tc = Integer.parseInt(in.nextLine());
        for(int i = 1; i <= tc; i++) {
            String[] s = in.nextLine().split(" ");
            bi = new BigInteger(s[0]);
            a = Math.min(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            b = Math.max(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
            visited = new boolean[bi.toString().length()];
            bigIdx = new ArrayList<>();
            StringBuffer temp = new StringBuffer("");
          
            for(int j = 0; j < bi.toString().length(); j++) {
                int jari = Character.getNumericValue(bi.toString().charAt(j));
                if(jari >= b || jari >= a) {
                    if(jari == b) {
                        bigIdx.add(j);
                        visited[j] = true;
                    } else if(jari == a) {
                        visited[j] = true;
                    } else {
                        visited[j] = false;
                        temp.append(a);
                        for(int r = j; r < visited.length; r++) {
                            //이거 r범위를 테케랑 맞춰볼라고 j+1 -> j로 변경해봄
                            temp.append(b);
                        }
                    }
                } else {
                    if(visited.length == 1) {
                        sb.append("#"+i+" -1");
                        sb.append("\n");
                        break;
                    } else {
                        if(bigIdx.size() != 0) {
                            temp.deleteCharAt(bigIdx.get(bigIdx.size()-1));
                            temp.insert(bigIdx.get(bigIdx.size()-1), String.valueOf(a));
                            for(int q = bigIdx.get(bigIdx.size()); q < visited.length; q++) {
                                temp.append(String.valueOf(b));
                        }
                        } else {
                            for(int p = j+1; p < visited.length-1; p++) {
                                temp.append(b);
                            }
                        }
                    }
                }
            }

            sb.append("#"+i+" "+temp);
            sb.append("\n");
        }
        
        System.out.println(sb);
   }
}

//242421222
//[1,3] 4배열
//4의 위치(인덱스)를 4배열에 담아서 뒷부분이 주어진 수로 구현이 불가하다면 4배열의 마지막 값으로 돌아가 
//2(작은 수)를 넣어주고 뒷부분은 다 4(큰 수)로 넣어줌 
//4배열에 담긴 값이 없는데 주어진 수가 한자리 수면 -1 / 아니면 더 큰수로 자리수를 1낮춰 때려박기
// 이전 상태: true
// 원래 숫자: 2212
// 42
// 새로 만드는 숫자: 
// 들고 있는 숫자: 2 4
//