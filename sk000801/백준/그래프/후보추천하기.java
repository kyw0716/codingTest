package sk000801.백준.그래프;
import java.util.*;
import java.io.*;

public class 후보추천하기 {

    public static class Student implements Comparable<Student>{
        int num;
        int call;
        int time;

        public Student(int num, int call, int time) {
            this.num = num; //학생 번호
            this.call = call; //불린 횟수
            this.time = time; //불린 때(?)
        }

        @Override
        public int compareTo(Student s) {
            //추천 수가 같다면 시간 순으로 비교(더 빠른게 앞으로)
            if(this.call == s.call) return this.time-s.time;
            else if(this.call<s.call) return -1;
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int all = Integer.parseInt(br.readLine());
        int[] ans = new int[101];
        ArrayList<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < all; i++) {
            int stu = Integer.parseInt(st.nextToken());
            if(ans[stu]>0) { //이미 한번 추천 받은 학생
                ans[stu]++;
                for(int j = 0; j < list.size(); j++) {
                    if(list.get(j).num == stu) {
                        list.get(j).call++;
                        break;
                    }
                }
            } else { //처음 추천 받는 학생
                if(list.size()>=n) { //이미 사진 게시판이 찼다면
                    list.sort(Comparator.naturalOrder()); //추천순 오름차순으로 정렬
                    int num = list.get(0).num;
                    ans[num] = 0;
                    list.remove(0); //추천받은 횟수가 가장 작은 학생 제거
                }
                list.add(new Student(stu, 1, i));
                ans[stu] = 1;
            }
        }

        for(int i = 0; i <= 100; i++) {
            if(ans[i] > 0) {
                System.out.print(i+" ");
            }
        }
    }
}
