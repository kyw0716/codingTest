function solution(n) {
  return parseInt([...n.toString(3)].reverse().join(""), 3);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/68935
// number.toString(숫자) => 숫자 진법으로 변환
// parseInt(문자열, 숫자) => 숫자 진법으로 이루어진 문자를 10진법 숫자로 바꾸어줌
