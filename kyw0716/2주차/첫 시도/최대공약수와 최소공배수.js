function solution(n, m) {
  let answer = [];
  const nArray = [];
  const mArray = [];
  let count = 1;
  for (let i = 0; i <= n; i++) {
    if (n % i == 0) nArray.push(i);
  }
  for (let i = 0; i <= m; i++) {
    if (m % i == 0) mArray.push(i);
  }
  answer.push(Math.max(...nArray.filter((value) => mArray.includes(value))));
  while (count <= n * m) {
    if (count % n === 0 && count % m === 0) {
      answer.push(count);
      break;
    }
    count++;
  }

  return answer;
}
