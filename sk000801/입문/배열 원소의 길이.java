class Solution {
    public int[] solution(String[] strlist) {
        int[] leng = new int[strlist.length];
        for(int i = 0; i < strlist.length; i++) {
            leng[i] = strlist[i].length();
        }
        return leng;
    }
}