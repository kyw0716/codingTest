function solution(num, k) {
  const index = String(num).split("").indexOf(`${k}`);
  return index < 0 ? index : index + 1;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120904
