function solution(n) {
  return String(n)
    .split("")
    .reverse()
    .map((value) => Number(value));
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12932
