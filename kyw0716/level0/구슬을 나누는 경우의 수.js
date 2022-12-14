const factorial = (number) => {
  number = BigInt(number);
  let result = BigInt(1);

  while (number > 0) {
    result *= number;
    number -= BigInt(1);
  }

  return BigInt(result);
};

function solution(n, m) {
  return factorial(n) / (factorial(n - m) * factorial(m));
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120840#
