function solution(n) {
  return Number(
    String(n)
      .split("")
      .sort((a, b) => Number(b) - Number(a))
      .join("")
  );
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12933
