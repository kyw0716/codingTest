function solution(x) {
  return (
    x %
      String(x)
        .split("")
        .reduce((s, c) => s + Number(c), 0) ===
    0
  );
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12947
