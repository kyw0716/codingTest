package sk000801.복습;

import java.util.*;
//43분
//테케에서 오류가 나는데 왜,,
public class 과제진행하기 {
    static int idx = 0;
    static class Subject {
        String name;
        int time;
        int left;

        public Subject(String name, int time, int left) {
            this.name = name;
            this.time = time;
            this.left = left;
        }
    }
    public static void putVal(Stack<Subject> stack, Subject next, int curTime, String[] answer) {
        if(stack.isEmpty()) return;

        Subject sub = stack.peek();

        if(curTime + sub.left <= next.time) {
            answer[idx++] = stack.pop().name;
            putVal(stack, next, curTime+sub.left, answer);
        } else {
            sub.left -= next.time-curTime;
        }
    }
    public static String[] solution(String[][] plans) {
        List<Subject> list = new ArrayList<>();
        for(int i = 0; i < plans.length; i++) {
            int time = 60*Integer.parseInt(plans[i][1].split(":")[0])+Integer.parseInt(plans[i][2]);
            int left = Integer.parseInt(plans[i][2]);
            list.add(new Subject(plans[i][0], time, left));
        }
        list.sort(new Comparator<Subject>() {
            @Override
            public int compare(Subject s1, Subject s2) {
                return s1.time-s2.time;
            }
        });

        Stack<Subject> stack = new Stack<>();
        String[] answer = new String[plans.length];
        int curTime = 0;

        for(int i = 0; i < list.size(); i++) {
            if(stack.isEmpty()) {
                stack.push(list.get(i));
                continue;
            }

            Subject next = list.get(i);
            Subject cur = stack.peek();
            curTime = cur.time;

            if(curTime+cur.left > next.time) {
                cur.left -= next.time-curTime;
            } else putVal(stack, next, curTime, answer);

            stack.push(next);
        }

        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[] ans = solution(plans);
        for(int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
