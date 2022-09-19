function solution(queue1, queue2) {
  const getSum = (arr) => arr.reduce((sum, curr) => sum + curr, 0);
  let queue3 = [...queue1, ...queue2, ...queue2, ...queue1];

  let half = getSum(queue3) / 4;
  if ((half * 2) % 2 !== 0) return -1;

  let count = 0;
  let sumOfQueue1 = getSum(queue1);

  let startIndex = 0;
  let endIndex = queue3.length / 2;

  while (count <= queue3.length) {
    if (sumOfQueue1 === half) return count;
    if (sumOfQueue1 > half) {
      sumOfQueue1 -= queue3[startIndex];
      startIndex += 1;
    } else {
      sumOfQueue1 += queue3[endIndex];
      endIndex += 1;
    }
    count++;
  }
  return -1;
}
