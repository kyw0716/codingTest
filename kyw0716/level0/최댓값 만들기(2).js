function solution(numbers) {
  numbers.sort((a, b) => a - b);

  const max1 = numbers[0] * numbers[1];
  const max2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];

  return Math.max(max1, max2);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120862
