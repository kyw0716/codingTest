function solution(n, a, b) {
  var answer = 1;
  while (true) {
    if (Math.abs(a - b) === 1 && Math.ceil(a / 2) === Math.ceil(b / 2)) break;
    a = Math.ceil(a / 2);
    b = Math.ceil(b / 2);
    answer += 1;
  }
  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12985#
