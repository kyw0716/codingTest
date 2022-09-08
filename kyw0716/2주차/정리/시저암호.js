function solution(s, n) {
  let smallCode = "abcdefghijklmnopqrstuvwxyz".split("");
  let largeCode = "abcdefghijklmnopqrstuvwxyz".toUpperCase().split("");

  return s
    .split("")
    .map((value) => {
      if (value === " ") return " ";
      if (smallCode.includes(value)) {
        return smallCode[(smallCode.indexOf(value) + n) % smallCode.length];
      }
      if (largeCode.includes(value)) {
        return largeCode[(largeCode.indexOf(value) + n) % largeCode.length];
      }
    })
    .join("");
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12926
