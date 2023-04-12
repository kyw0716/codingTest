package sk000801.복습;
import java.util.*;

//9분!!
//리스트에 차례대로 나올 수 있는 스킬의 경우의 수를 담고
//skill_trees 안의 문자열을 skill에 해당되는 글자만 남긴다
//만약 이 과정에서 빈 문자열이 됐다면 비교할 필요가 없으므로 정답+1
//위의 리스트 안에 그 값이 있다면 정답+1
public class 스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(int i = 0; i < skill.length(); i++) {
            list.add(skill.substring(0, i+1));
        }
        for(int i = 0; i < skill_trees.length; i++) {
            skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", "");
            if(skill_trees[i].equals("")) answer++;
            if(list.contains(skill_trees[i])) answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        String skill = "ABC";
        String[] skill_trees = {"OPQ"};
        System.out.println(solution(skill, skill_trees));
    }
}
