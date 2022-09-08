function solution(s) {
  return s
    .split(" ")
    .map((word) => {
      return word
        .split("")
        .map((alphabet, index) => {
          if (index % 2 == 0) {
            return alphabet.toUpperCase();
          }
          return alphabet.toLowerCase();
        })
        .join("");
    })
    .join(" ");
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12930
