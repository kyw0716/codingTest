function solution(answers) {
  var answer = [];
  let Method = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  let score = [0, 0, 0];

  answers.forEach((value, index) => {
    if (Method[0][index % Method[0].length] === value) score[0] += 1;
    if (Method[1][index % Method[1].length] === value) score[1] += 1;
    if (Method[2][index % Method[2].length] === value) score[2] += 1;
  });
  let MaxScore = Math.max(...score);
  score.forEach((value, index) => {
    if (value === MaxScore) answer.push(index + 1);
  });
  answer.sort((a, b) => a - b);
  return answer;
}

// 일정 구간이 반복되면 그 구간의 길이로 나눈 나머지를 활용해보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
