function solution(answers) {
  var answer = [];
  let Method = [
    [1, 2, 3, 4, 5],
    [2, 1, 2, 3, 2, 4, 2, 5],
    [3, 3, 1, 1, 2, 2, 4, 4, 5, 5],
  ];
  let score = [0, 0, 0];

  Method.forEach((subArray, index) => {
    while (subArray.length < answers.length) {
      subArray.push(...subArray);
    }
  });
  Method.forEach((subArray, index) => {
    Method[index] = subArray.slice(0, answers.length);
  });
  answers.forEach((value, index) => {
    if (Method[0][index] === value) score[0] += 1;
    if (Method[1][index] === value) score[1] += 1;
    if (Method[2][index] === value) score[2] += 1;
  });
  let MaxScore = Math.max(...score);
  score.forEach((value, index) => {
    if (value === MaxScore) answer.push(index + 1);
  });
  answer.sort((a, b) => a - b);
  return answer;
}
