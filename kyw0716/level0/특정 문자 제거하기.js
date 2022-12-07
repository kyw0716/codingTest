function solution(my_string, letter) {
  return my_string
    .split("")
    .filter((l) => l !== letter)
    .join("");
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120826
