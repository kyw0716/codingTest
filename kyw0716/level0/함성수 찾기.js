function getIsPrime(number) {
  let isPrime = true;

  for (let i = 2; i < number; i++) {
    if (number % i === 0) {
      isPrime = false;
      break;
    }
  }

  return isPrime;
}

function solution(n) {
  return new Array(n)
    .fill(1)
    .map((v, i) => v + i)
    .filter((v) => !getIsPrime(v)).length;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120846
