// 순열 구하기
function getPermutation(arr, selectNumber) {
  let results = [];
  if (selectNumber === 1) return arr.map((v) => [...v]);
  arr.forEach((fixed, index, original) => {
    let rest = original.filter((v, i) => i !== index);
    let permutations = getPermutation(rest, selectNumber - 1);
    let attach = permutations.map((permutation) => [fixed, ...permutation]);
    results.push(...attach);
  });

  return results;
}

function getPrimeNumber(n) {
  let arr = Array(n + 1)
    .fill(true)
    .fill(false, 0, 2);
  for (let i = 2; i * i <= n; i++) {
    if (arr[i])
      for (let j = i * i; j <= n; j += i) {
        if (j % i === 0) arr[j] = false;
      }
  }

  return arr;
}

function solution(numbers) {
  let numbersArray = numbers.split("");
  let allPermutations = [];
  let primeArray = [];
  let answer = 0;

  for (let i = 1; i <= numbers.length; i++) {
    let permutations = getPermutation(numbersArray, i).map((v) =>
      Number(v.join(""))
    );
    allPermutations.push(...permutations);
  }
  allPermutations = [...new Set(allPermutations)];
  allPermutations.sort((a, b) => a - b);

  primeArray = getPrimeNumber(allPermutations.at(-1));
  allPermutations.forEach((value) => {
    if (primeArray[value]) answer++;
  });

  return answer;
}

// 순열과 조합 만드는 알고리즘, 소수 찾는 알고리즘 숙지하지
// https://school.programmers.co.kr/learn/courses/30/lessons/42839
