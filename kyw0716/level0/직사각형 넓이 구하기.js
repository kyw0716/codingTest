function solution(dots) {
  let width = [
    Math.abs(dots[0][0] - dots[1][0]),
    Math.abs(dots[0][0] - dots[2][0]),
  ];
  let height = [
    Math.abs(dots[0][1] - dots[1][1]),
    Math.abs(dots[0][1] - dots[2][1]),
  ];

  return Math.max(...width) * Math.max(...height);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120860
