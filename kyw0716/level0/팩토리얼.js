const factorial = (number) => {
  return new Array(number)
    .fill(1)
    .map((v, i) => v + i)
    .reduce((acc, curr) => (acc *= curr), 1);
};

function solution(n) {
  for (let i = 1; i <= 10; i++) {
    const fac = factorial(i);

    if (fac > n) return i - 1;
    if (fac === n) return i;
  }
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120848#
