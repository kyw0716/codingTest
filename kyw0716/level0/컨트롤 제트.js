function solution(s) {
  return s
    .split(" ")
    .filter((v, i, arr) => arr[i + 1] !== "Z")
    .filter((v) => v !== "Z")
    .map(Number)
    .reduce((a, c) => a + c, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120853
