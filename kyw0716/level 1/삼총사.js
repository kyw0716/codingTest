const getCombinations = (arr, selectNumber) => {
  const results = [];
  if (selectNumber === 1) return arr.map((el) => [el]);

  arr.forEach((fixed, index, origin) => {
    const rest = origin.slice(index + 1);
    const combinations = getCombinations(rest, selectNumber - 1);
    const attached = combinations.map((el) => [fixed, ...el]);
    results.push(...attached);
  });

  return results;
};

const arraySum = (arr) => {
  return arr.reduce((acc, curr) => acc + curr, 0);
};

function solution(number) {
  return getCombinations(number, 3).filter((arr) => arraySum(arr) === 0).length;
}
// https://school.programmers.co.kr/learn/courses/30/lessons/131705
