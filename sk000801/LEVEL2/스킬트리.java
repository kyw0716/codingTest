package sk000801.LEVEL2;
import java.util.*;

//그 생각이 들긴 했다 정규표현식이 있으면 진짜 빨리 풀 수 있겠다는..
//정규식을 통해 skill에 해당하는 글자들만남기고
//(틀린)
//이중 for문을 통해 해당 글자의 위치(index)를 담음
//앞은 안들렀는데 다음 인덱스 값이 존재한다면 x
//0을 안거쳤을 때 x
//그렇게 마지막 인덱스까지 도달했을 때 answer++;
//밧 오류가 많았던듯
//(맞춘)
//정답 문자열을 시작부터 부분부분 잘라
//남은 문자열이 이 잘린 문자열과 같으면 answer++;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        if(skill.length() == 1) return skill_trees.length;
        for(int i = 0; i < skill_trees.length; i++) {
            int[] index = new int[skill.length()];
            Arrays.fill(index, -1);
            String temp = skill_trees[i].replaceAll("[^" + skill + " ]", "");
            if(temp.equals("")) {
                answer++;
                continue;
            }
            for (int j = 1; j <= skill.length(); j++) {
                if (skill.substring(0, j).equals(temp)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
