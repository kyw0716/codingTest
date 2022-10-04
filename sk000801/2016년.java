class Solution {
    public String solution(int a, int b) {
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU","FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int day2 = 0;
        for(int i=1; i<=a; i++) {
            if(i==a) day2 += b;
            else {day2 += day[i-1];} 
        }
        String answer = week[day2%7];
        return answer;
    }
}