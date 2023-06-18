package sk000801.LEVEL3;
import java.util.*;
//73분
//코드는 금방 33분만에 짰는데 같은 재생횟수라면
//고유번호가 낮아야 함, 근데 이걸 map으로 묶어버리니 고유번호가 마지막걸로 갱신됨;;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Integer>> map = new HashMap<>(); //장르, 재생횟수
        //여기서 재생횟수가 같아서 잘리나보다
        Map<Integer, List<Integer>> num = new HashMap<>(); //재생횟수, 고유번호
        Map<String, Integer> gaesu = new HashMap<>(); //장르, 전체 재생횟수
        Map<String, List<Integer>> ans = new HashMap<>();
        
        //장르와 재생횟수(리스트), 재생횟수-고유번호
        for(int i = 0; i < genres.length; i++) {
            if(!map.containsKey(genres[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(plays[i]);
                map.put(genres[i], list);
                gaesu.put(genres[i], plays[i]);
            } else {
                List<Integer> list = map.get(genres[i]);
                list.add(plays[i]);
                map.put(genres[i], list);
                gaesu.put(genres[i], gaesu.get(genres[i])+plays[i]);
            }
            List<Integer> idx = new ArrayList<>();
            //문제구간
            if(num.containsKey(plays[i])) {
                idx = num.get(plays[i]);
                idx.add(i);
            } else {
                idx.add(i);
            }
            num.put(plays[i], idx);
        }
        
        for(Integer i : num.keySet()) {
            List<Integer> idx = num.get(i);
            Collections.sort(idx);
            num.put(i, idx);
        }
        
        //일단 장르별 재생횟수를 담은 리스트를 내림차순으로 정렬
        for(String s : map.keySet()) {
            List<Integer> list = map.get(s);
            list.sort(Collections.reverseOrder());
            List<Integer> list2 = new ArrayList<>();
            
            List<Integer> idx = num.get(list.get(0));
            if(list.size() == 1 && idx.size() == 1) {
                list2.add(idx.get(0));
            } else {
                list2.add(idx.get(0));
                if(idx.size() > 1) list2.add(idx.get(1));
                else {
                    idx = num.get(list.get(1));
                    list2.add(idx.get(0));
                }
            }
            ans.put(s, list2);
        }
        
        //장르가 불린 개수를 내림차순으로 정렬
        List<Integer> allPlay = new ArrayList<>(gaesu.values());
        allPlay.sort(Collections.reverseOrder());
        
        //많이 불린 장르의 노래들을 고름
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < allPlay.size(); i++) {
            String name = "";
            for(String s : gaesu.keySet()) {
                if(gaesu.get(s) == allPlay.get(i)) {
                    name = s;
                    break;
                }
            }
            List<Integer> ans2 = ans.get(name);
            if(ans2.size() == 1) answer.add(ans2.get(0));
            else {
                answer.add(ans2.get(0));
                answer.add(ans2.get(1));
            }
        }

        int[] res = new int[answer.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = answer.get(i);
        }
        return res;
    }
}