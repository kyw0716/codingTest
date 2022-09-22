function solution(s) {
  return s
    .toLowerCase()
    .replace(/\s[a-z]/g, (char) => char.toUpperCase())
    .replace(/^[a-z]/, (char) => char.toUpperCase());
}
// 정규 표현식 강의 듣자
// https://school.programmers.co.kr/learn/courses/30/lessons/12951#
