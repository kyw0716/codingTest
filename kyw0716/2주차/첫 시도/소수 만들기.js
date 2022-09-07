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
