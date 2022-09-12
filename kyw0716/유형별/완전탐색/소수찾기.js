// 순열 구하기
function getPermutation(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr.map((number) => [...number]);
  arr.forEach((fixed, index, origin) => {
    let rest = arr.filter((n, i) => i !== index);
    let permutation = getPermutation(rest, selectNumber - 1);
    let attach = permutation.map((element) => [fixed, ...element]);
    results.push(...attach);
  });
  return results;
}

function generatePrimeNumberArray(n) {
  let arr = Array(n + 1)
    .fill(true)
    .fill(false, 0, 2);
  for (let i = 2; i * i <= n; i++) {
    if (arr[i]) {
      for (let j = i * i; j <= n; j += i) {
        arr[j] = false;
      }
    }
  }
  return arr;
}

function solution(numbers) {
  let permutations = [];
  let maxNumber = Number(
    numbers
      .split("")
      .sort((a, b) => Number(b) - Number(a))
      .join("")
  );
  let primeNumbers = generatePrimeNumberArray(maxNumber)
    .map((v, i) => (v ? i : 0))
    .filter((v) => v);
  for (let i = 1; i <= numbers.split("").length; i++) {
    permutations.push(
      ...getPermutation(numbers.split(""), i).map((subArray) =>
        Number(subArray.join("").replace(/\,/g, ""))
      )
    );
  }
  permutations = new Set(permutations);
  permutations = [...permutations].filter((v) => primeNumbers.includes(v));
  return permutations.length;
}

// 순열과 조합 만드는 알고리즘, 소수 찾는 알고리즘 숙지하지
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
