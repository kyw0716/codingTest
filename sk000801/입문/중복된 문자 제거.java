import java.util.*;
class Solution {
    public String solution(String my_string) {
        List<String> result = new ArrayList<>();
        String[] s = my_string.split("");
        for(String ss : s) {
            if(!result.contains(ss)) {
                result.add(ss);
            }
        }
        return String.join("", result);
    }
}

// return my_string.chars()
// .mapToObj(Character::toString)
// .distinct()
// .collect(Collectors.joining());