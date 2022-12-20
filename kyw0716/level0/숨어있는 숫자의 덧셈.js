function solution(my_string) {
  return my_string
    .replace(/[a-z]|[A-Z]/g, "")
    .split("")
    .map((v) => parseInt(v, 10))
    .reduce((acc, curr) => acc + curr, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120851
