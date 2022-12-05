function solution(array) {
  const noDuplicate = [...new Set(array)];
  const freq = {};
  let maxFreq1, maxFreq2;

  for (let i = 0; i < array.length; i++) {
    if (freq[array[i]] !== undefined) {
      freq[array[i]]++;
      continue;
    }

    freq[array[i]] = 1;
  }

  noDuplicate.sort((a, b) => freq[b] - freq[a]);

  maxFreq1 = noDuplicate[0];
  maxFreq2 = noDuplicate[1];

  if (freq[maxFreq1] === freq[maxFreq2]) return -1;
  return Number(maxFreq1);
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120812
