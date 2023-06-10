package sk000801.복습;
import java.util.*;

//15분
//생각하면서 차분히 코드를 짜니까 바로 성공!
public class 과제진행하기2 {
    static int idx = 0;
    public static class HW {
        String name;
        int start;
        int time;

        public HW(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }

    public static void recur(Stack<HW> stack, int curTime, HW next, String[] answer) {
        if(!stack.isEmpty()) {
            HW cur = stack.peek();

            if(curTime+cur.time <= next.start) {
                answer[idx++] = stack.pop().name;
                recur(stack, curTime+cur.time, next, answer);
            } else {
                cur.time -= next.start-curTime;
            }
        }
    }

    public static String[] solution(String[][] plans) {
        List<HW> list = new ArrayList<>();
        String[] answer = new String[plans.length];

        for(int i = 0; i < plans.length; i++) {
            int start = 60*Integer.parseInt(plans[i][1].split(":")[0])+Integer.parseInt(plans[i][1].split(":")[1]);
            int time = Integer.parseInt(plans[i][2]);
            list.add(new HW(plans[i][0], start, time));
        }

        list.sort(new Comparator<HW>() {
            @Override
            public int compare(HW h1, HW h2) {
                return h1.start-h2.start;
            }
        });

        Stack<HW> stack = new Stack<>();
        int curTime = 0;
        for(int i = 0; i < list.size(); i++) {
            if(stack.isEmpty()) {
                stack.add(list.get(i));
                continue;
            }

            HW cur = stack.peek();
            HW next = list.get(i);
            curTime = cur.start;

            if(curTime+cur.time <= next.start) {
                recur(stack, curTime, next, answer);
            } else {
                cur.time -= next.start-curTime;
            }

            stack.push(next);
        }

        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        String[] res = solution(plans);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
