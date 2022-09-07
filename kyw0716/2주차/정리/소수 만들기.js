function getCombinations(arr, selectNumber) {
  const results = [];
  if (selectNumber === 1) return arr.map((value) => [value]);

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNumber - 1);
    const attached = combinations.map((combination) => [fixed, ...combination]);
    results.push(...attached);
  });

  return results;
}
function isPrimeNumber(number) {
  if (number === 1) return false;
  for (let i = 2; i <= Math.ceil(Math.sqrt(number)); i++) {
    if (number % i === 0) return false;
  }
  return true;
}
function solution(nums) {
  var answer = 0;
  getCombinations(nums, 3).forEach((selectedNumberArray) => {
    if (
      isPrimeNumber(
        selectedNumberArray.reduce((sum, currentValue) => (sum += currentValue))
      )
    )
      answer += 1;
  });

  return answer;
}

// 3개를 골라 부분 배열을 만드는 과정 => 조합 만들기로 해결함. 이거 알고리즘 알고 있어야 될듯
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
