function solution(n) {
  let count = 0;
  let answer = 0;

  while (count < n) {
    answer += 1;
    if (answer % 3 !== 0 && `${answer}`.match(/3/) === null) count += 1;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120871
