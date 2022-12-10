import java.util.*;
class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        String s1 = s.substring(2, s.length());
        String s2 = s1.substring(0, s.length()-4).replace("},{", " ");
        String[] s3 = s2.split(" ");
        Arrays.sort(s3, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });

        for (String ss : s3) {
            String[] numbers = ss.split(",");
            for (int i = 0; i < numbers.length; i++) {
                int num = Integer.parseInt(numbers[i]);
                if (!answer.contains(num)) {
                    answer.add(num);
                }
            }
        }
        int[] realAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            realAnswer[i] = answer.get(i);
        }
        return realAnswer;
    }
}