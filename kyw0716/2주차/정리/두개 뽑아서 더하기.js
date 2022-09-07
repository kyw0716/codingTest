function getCombination(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr.map((value) => [value]);

  arr.forEach((fixed, index, original) => {
    const remain = original.slice(index + 1);
    const combinations = getCombination(remain, selectNumber - 1);
    const attach = combinations.map((combination) => [fixed, ...combination]);
    results.push(...attach);
  });
  return results;
}

function solution(numbers) {
  let answer = [
    ...new Set(
      getCombination(numbers, 2)
        .map((array) => array.reduce((sum, curr) => (sum += curr), 0))
        .sort((a, b) => a - b)
    ),
  ];
  return answer;
}

// set쓰면 중복 제거됨, combination 알고리즘 잘 써보기
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
