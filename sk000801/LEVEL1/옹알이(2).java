class Solution {
    String[] ableWord = {"aya", "ye", "woo", "ma"};
    String[] repeat = {"ayaaya", "yeye", "woowoo", "mama"};
    
    public String remove(String word) {
        for (int i = 0; i < ableWord.length; i++) {
            if (word.contains(repeat[i])) {
                return word;
            } else {
                word = word.replaceAll(ableWord[i]," ");
            }
        }
        return word.replaceAll(" ", "");
    }
    
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s : babbling) {
            if (remove(s).equals("")) {
                answer++;
            }
        }
        return answer;
    }
}