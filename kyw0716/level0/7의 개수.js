function solution(array) {
  return array
    .map(String)
    .map((v) => v.split("").filter((s) => s === "7").length)
    .reduce((a, c) => a + c, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120912
