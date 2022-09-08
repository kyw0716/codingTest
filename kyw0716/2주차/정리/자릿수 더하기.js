function solution(n) {
  return String(n)
    .split("")
    .reduce((sum, curr) => sum + Number(curr), 0);
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12931
