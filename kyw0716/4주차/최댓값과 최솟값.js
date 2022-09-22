function solution(s) {
  return `${Math.min(...s.split(" ").map((v) => Number(v)))} ${Math.max(
    ...s.split(" ").map((v) => Number(v))
  )}`;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
