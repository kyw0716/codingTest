function solution(n) {
  return Math.sqrt(n) % 1 === 0 ? (Math.sqrt(n) + 1) ** 2 : -1;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12934
