function solution(lottos, win_nums) {
  var answer = [];
  let correctNum = lottos.filter((lottoNum) =>
    win_nums.includes(lottoNum)
  ).length;
  let count = lottos.filter((lottoNum) => lottoNum === 0).length + correctNum;
  answer.push(count < 2 ? 6 : 7 - count, correctNum < 2 ? 6 : 7 - correctNum);

  return answer;
}
