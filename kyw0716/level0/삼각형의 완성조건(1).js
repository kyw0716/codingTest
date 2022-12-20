function solution(sides) {
  sides.sort((a, b) => a - b);
  const max = sides.pop();
  return max < sides.reduce((a, c) => a + c, 0) ? 1 : 2;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120889
