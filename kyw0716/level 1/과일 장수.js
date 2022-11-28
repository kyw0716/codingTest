function solution(k, m, score) {
  const box = [];
  let answer = 0;

  score.sort((a, b) => a - b);

  while (score.length > 0) {
    box.push(score.pop());
    if (box.length === m) {
      const minScore = Math.min(...box);

      answer += m * minScore;

      box.splice(0, box.length);
    }
  }

  return answer;
}

// score를 크기순으로 정렬한다.
// 배열에 m만큼 사과를 담는다.
// 배열 내 최솟값을 구한다.
// m * 최솟값을 answer에 더한다.
// 위과정을 반복한다.

//https://school.programmers.co.kr/learn/courses/30/lessons/135808
