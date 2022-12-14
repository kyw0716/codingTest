const winning = {
  2: 0,
  0: 5,
  5: 2,
};

function solution(rsp) {
  let answer = "";

  for (let i = 0; i < rsp.length; i++) {
    answer += winning[rsp[i]];
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120839
