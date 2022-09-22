function solution(A, B) {
  var answer = 0;
  let repeatTime = A.length;
  A.sort((a, b) => a - b);
  B.sort((a, b) => a - b);
  for (let i = 0; i < repeatTime; i++) {
    A[0] <= B[0]
      ? (answer += A.shift() * B.pop())
      : (answer += A.pop() * B.shift());
  }
  return answer;
}

//https://school.programmers.co.kr/learn/courses/30/lessons/12941#
