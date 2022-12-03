function YaksooCount(number) {
  let count = 0;
  let isOdd =
    Math.sqrt(number) - Math.floor(Math.sqrt(number)) === 0 && number !== 1;

  for (let i = 1; i <= Math.sqrt(number); i++) {
    if (number % i === 0) count += 1;
  }

  return isOdd ? 2 * count - 1 : 2 * count;
}

function solution(number, limit, power) {
  var answer = 1;

  for (let i = 2; i <= number; i++) {
    const yaksoo = YaksooCount(i);
    if (yaksoo > limit) {
      answer += power;
      continue;
    }
    answer += yaksoo;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/136798
