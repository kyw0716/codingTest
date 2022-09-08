function solution(s) {
  const onlyNumber = Number(s.replace(/\+|\-/, ""));
  return s.match(/\+|\-/)
    ? s[0] === "-"
      ? -1 * onlyNumber
      : onlyNumber
    : onlyNumber;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/12925
