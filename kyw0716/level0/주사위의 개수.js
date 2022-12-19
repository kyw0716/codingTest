function solution(box, n) {
  return box
    .map((length) => Math.floor(length / n))
    .reduce((acc, curr) => (acc *= curr), 1);
}
// https://school.programmers.co.kr/learn/courses/30/lessons/120845
