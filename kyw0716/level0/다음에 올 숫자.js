function getIsSum(common) {
  const sumVal = common[1] - common[0];

  return common[1] + sumVal === common[2];
}

function getSumVal(first, second) {
  return second - first;
}

function getMulVal(first, second) {
  return second / first;
}

function solution(common) {
  if (getIsSum(common)) return common.at(-1) + getSumVal(common[0], common[1]);
  return common.at(-1) * getMulVal(common[0], common[1]);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120924
