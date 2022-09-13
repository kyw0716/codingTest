function getPermutation(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr.map((v) => [v]);

  arr.forEach((fixed, index, original) => {
    let rest = original.filter((v, i) => i !== index);
    let permutations = getPermutation(rest, selectNumber - 1);
    let attach = permutations.map((permutation) => [fixed, ...permutation]);
    results.push(...attach);
  });
  return results;
}

function solution(k, dungeons) {
  let allPosibility = getPermutation(dungeons, dungeons.length);
  let max = 0;

  for (let i = 0; i < allPosibility.length; i++) {
    let thisTired = k;
    let thisTrial = 0;
    for (let j = 0; j < allPosibility[0].length; j++) {
      if (thisTired >= allPosibility[i][j][0]) {
        thisTired -= allPosibility[i][j][1];
        thisTrial++;
      }
    }
    if (max < thisTrial) {
      max = thisTrial;
    }
    if (max === dungeons.length) break;
  }
  return max;
}

// 모든 경우의 수를 다 고려하는 방식에서 순열 떠올려보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/87946#
