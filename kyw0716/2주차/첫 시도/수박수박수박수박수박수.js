function solution(n) {
  let answer = "";
  for (let i = 0; i < n; i++) {
    if (i % 2 === 0) answer += "수";
    else answer += "박";
  }
  return answer;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12922
