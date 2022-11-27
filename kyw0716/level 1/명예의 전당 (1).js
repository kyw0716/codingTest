function solution(k, score) {
  let sortedScore = [];
  let result = [];

  for (let i = 0; i < score.length; i++) {
    sortedScore.push(score[i]);
    sortedScore.sort((a, b) => b - a);

    if (sortedScore.length >= k) {
      result.push(sortedScore.at(k - 1));
      continue;
    }

    result.push(sortedScore.at(-1));
  }

  return result;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/138477
