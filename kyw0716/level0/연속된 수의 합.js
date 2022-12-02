function getSumNumber(num) {
  let sum = 0;

  for (let i = 1; i < num; i++) {
    sum += i;
  }

  return sum;
}

function solution(num, total) {
  const sumNumber = getSumNumber(num);
  let keyNumber = (total - sumNumber) / num;
  let answer = [];

  for (let i = 0; i < num; i++) {
    answer.push(keyNumber + i);
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120923
