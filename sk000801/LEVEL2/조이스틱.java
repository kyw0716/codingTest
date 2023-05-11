package sk000801.LEVEL2;

//아 차례대로 문자를 맞추고
//다음 문자열로 넘어갈 때 커서를 옮겨야됨
//이때 중간에 A가 껴있으면 굳이 건드릴 필요가 없으니까
//오른쪽으로 그냥 넘어갈때랑 왼쪽으로 옮겨서 끝부터 내려올 때랑 이동의 최솟값을 구하면 됨
//https://school.programmers.co.kr/learn/courses/30/lessons/42860
//https://school.programmers.co.kr/questions/25982 이분 풀이 최솟값 더하는 부분 빼고 완전히 참고함ㅠㅠ
class 조이스틱 {
    public int solution(String name) {
        int answer = 0;
        
        int index;
        int move = name.length()-1;
        for(int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            answer += Math.min(c-'A', 'Z'-c+1);
            
            index = i+1;
            //연속되는 A개수 확인
            while(index < name.length() && name.charAt(index) == 'A') index++;
            //위에서 얘기했던 것처럼 오른쪽으로 커서를 넘기는 것과 왼쪽으로 돌아가 끝에서부터 커서를 넘기는것
            move = Math.min(move, i*2+name.length()-index);
            move = Math.min(move, (name.length()-index)*2+i);
        }
        return answer+move;
    }
}
