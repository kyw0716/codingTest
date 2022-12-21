function solution(n) {
  return String(n)
    .split("")
    .map(Number)
    .reduce((a, c) => a + c, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120906
