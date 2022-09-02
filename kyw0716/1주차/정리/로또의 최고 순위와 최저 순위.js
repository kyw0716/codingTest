function solution(lottos, win_nums) {
  var answer = [];
  let correctNum = lottos.filter((lottoNum) =>
    win_nums.includes(lottoNum)
  ).length;
  let count = lottos.filter((lottoNum) => lottoNum === 0).length + correctNum;
  answer.push(count < 2 ? 6 : 7 - count, correctNum < 2 ? 6 : 7 - correctNum);

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=javascr
// 새로운걸 많이 만들지 말고 주어진 변수들을 활용해서 문제 풀어보면 좋을듯
