package sk000801.LEVEL2;
import java.util.*;

//1시간 4분 + 알파
// https://sasca37.tistory.com/325님의 풀이를 완전 참고함
// 1. 과제 배열을 시작 시간 순으로 정렬
// 2. 진행 중인 과제를 스택에 담고, 현재 과제 vs 다음 과제를 비교 => 어느것을 진행할 지 결정
// 2- 스택이 비어있을 때 -> 새 과제를 하면 되므로 걍 push
// 2- 스택이 채워져 있을 떼 -> 현재 시간과 새 과제 시간 비교
// -> (새 과제 시간이 더 빠르면) 현재 과제 종료 후 pop
// -> (else) 현재 과제는 진행된 시간까지 빼주고, 새 작업을 push, 
class 과제진행하기 {
    int idx = 0;
    class Assign {
        private String name;
        private int start;
        private int time;
        
        public Assign(String name, int start, int time) {
            this.name = name;
            this.start = start;
            this.time = time;
        }
    }
    public void recur(Stack<Assign> stack, Assign next, int curTime, String[] answer) {
        if(stack.isEmpty()) return;
        
        //현재 진행중인 과제
        Assign curAssign = stack.peek(); 
        
        if(curTime + curAssign.time <= next.start) {
            answer[idx++] = stack.pop().name;
            recur(stack, next, curTime+curAssign.time, answer);
        } else {
            curAssign.time -= next.start-curTime;
        }
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Arrays.sort(plans, (o1, o2) -> {
            int a = Integer.parseInt(o1[1].split(":")[0])*60+Integer.parseInt(o1[1].split(":")[1]);
            int b = Integer.parseInt(o2[1].split(":")[0])*60+Integer.parseInt(o2[1].split(":")[1]);
            return a-b;
        });
        
        Stack<Assign> stack = new Stack<>(); //진행중인 과제
        
        int curTime = 0;
        
        for(int i = 0; i < plans.length; i++) {
            //진행중인 과제가 없을 때
            if(stack.isEmpty()) {
                int time = Integer.parseInt(plans[i][1].split(":")[0])*60+Integer.parseInt(plans[i][1].split(":")[1]);
                stack.push(new Assign(plans[i][0], time, Integer.parseInt(plans[i][2])));
                continue;
            }
            
            Assign cur = stack.peek();
            int time2 = Integer.parseInt(plans[i][1].split(":")[0])*60+Integer.parseInt(plans[i][1].split(":")[1]);
            Assign next = new Assign(plans[i][0], time2, Integer.parseInt(plans[i][2])); //새로운 과제
            
            //새로운 과제의 시작 시간 vs 진행 중인 과제의 종료 시간
            curTime = cur.start;
            
            //새로운 과제 시간 >= 현재 작업 시간
            if(curTime + cur.time <= next.start) recur(stack, next, curTime, answer);
            else {
            //새로운 과제 시간이 더 작을 때 => 시간을 갱신 하고, 새로운 과제의 작업 먼저 시작
                cur.time -= next.start-curTime;
            }
            
            stack.push(next);
        }
        
        //새로운 과제가 없을 때
        while(!stack.isEmpty()) {
            answer[idx++] = stack.pop().name;
        }
        return answer;
    }
}
