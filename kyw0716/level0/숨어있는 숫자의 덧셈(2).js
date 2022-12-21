function solution(my_string) {
  my_string = my_string.replace(/[A-Z]|[a-z]/g, " ").replace(/\s{1,}/g, " ");
  return my_string
    .split(" ")
    .map(Number)
    .reduce((a, c) => a + c, 0);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120864
