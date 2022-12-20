function solution(my_string) {
  return my_string
    .replace(/[a-z]/g, "")
    .split("")
    .map((v) => parseInt(v, 10))
    .sort((a, b) => a - b);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120850
