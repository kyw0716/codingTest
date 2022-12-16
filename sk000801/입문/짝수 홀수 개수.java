class Solution {
    public int[] solution(int[] num_list) {
        int[] gaesu = new int[2];
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i]%2==0) gaesu[0]++;
            else gaesu[1]++;
        }
        return gaesu;
    }
}