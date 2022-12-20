class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i = 0; i < dic.length; i++) {
            String s = dic[i];
            int count = 0;
            for(int j = 0; j < spell.length; j++) {
                int l1 = s.length();
                s = s.replaceFirst(spell[j], "");
                if(l1-s.length() != 0) count++;
            }
            if(s.equals("") && count == spell.length) return 1;
        }
        return 2;
    }
}