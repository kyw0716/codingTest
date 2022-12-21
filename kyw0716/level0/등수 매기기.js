function solution(score) {
  score = score.map((s) => {
    return (s[0] + s[1]) / 2;
  });

  let sorted = [...score];
  sorted.sort((a, b) => b - a);

  score = score.map((v) => {
    return sorted.indexOf(v) + 1;
  });

  return score;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120882
