function solution(p) {
  return p
    .split("")
    .map((v, i) => (i < p.length - 4 ? "*" : v))
    .join("");
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12948
