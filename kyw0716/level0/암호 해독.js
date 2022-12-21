function solution(cipher, code) {
  return cipher
    .split("")
    .filter((v, i) => (i + 1) % code === 0)
    .join("");
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120892
