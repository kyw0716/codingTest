package sk000801.복습;
import java.util.*;

//40분
//괜히 이것저것 다 출력시켜놔서 내 혼란만 가중시켰다....
public class 순위검색 {
    //cpp, java, python, -
    //backend, frontend, -
    //junior, senior, -
    //chicken, pizza, -
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        HashMap<String, List<Integer>> map = new HashMap<>();
        for(String s : info) {
            String[] op = s.split(" ");
            String option = "";
            for(int i = 0; i < 4; i++) {
                option += op[i];
            }
            int num = Integer.parseInt(op[4]);
            if(map.containsKey(option)) {
                List<Integer> list = map.get(option);
                list.add(num);
                map.put(option, list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                map.put(option, list);
            }
        }

        //System.out.println(map);

        //배열 오름차순으로 정렬
        for(String s : map.keySet()) {
            List<Integer> list = map.get(s);
            Collections.sort(list);
            map.put(s, list);
        }

        //query는 십만이라 for문 하나에서 끝내야됨
        int idx = 0;
        for(String s : query) {
            String option = s.replaceAll("[0-9]", "");
            s = s.replaceAll("-", "");
            s = s.replaceAll(" and", "");
            String[] op = s.split(" ");

            int num = 0;
            if(option.equals(s)) num = 0;
            else num = Integer.parseInt(s.replaceAll("[^0-9]", ""));

            for(String val : map.keySet()) {
                int hap = 0;
                for(int i = 0; i < 4; i++) {
                    if(val.contains(op[i])) hap++;
                }
                if(hap == 4) {
                    List<Integer> list = map.get(val);
                    int start = 0;
                    int end = list.size();
                    //지난번에 시간 복잡도에 잡혀서 그때 그대로 이분탐색해서 풀었돠
                    while(start < end) {
                        int mid = (start+end)/2;
                        if(list.get(mid) < num) start = mid+1;
                        else end = mid;
                    }
                    answer[idx] += list.size()-start;
                }
            }
            idx++;
        }

        return answer;

    }
    public static void main(String[] args) {
        String[] info1 = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query1 = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] res = solution(info1, query1);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
