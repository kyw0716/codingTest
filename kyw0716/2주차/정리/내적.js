function solution(a, b) {
  var answer = 0;
  a.map((value, index) => {
    answer += value * b[index];
  });
  return answer;
}
//https://school.programmers.co.kr/learn/courses/30/lessons/70128
