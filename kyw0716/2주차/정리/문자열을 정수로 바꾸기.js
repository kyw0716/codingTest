function solution(s) {
  const onlyNumber = Number(s.replace(/\+|\-/, ""));
  return s[0] === "-" ? -1 * onlyNumber : onlyNumber;
}
// 쓸데없는 조건문 안쓰도록 조심하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12925
