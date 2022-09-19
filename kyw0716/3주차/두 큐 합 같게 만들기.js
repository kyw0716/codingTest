function solution(queue1, queue2) {
  let queue3 = [...queue1, ...queue2];

  let half = queue3.reduce((sum, curr) => sum + curr, 0) / 2;
  if ((half * 2) % 2 !== 0) return -1;

  let count = 0;
  let sumOfQueue1 = queue1.reduce((sum, curr) => sum + curr, 0);

  while (sumOfQueue1 !== half) {
    if (sumOfQueue1 > half) {
      queue2.push(queue1.shift());
    } else if (sumOfQueue1 < half) {
      queue1.push(queue2.shift());
    }
    sumOfQueue1 = queue1.reduce((sum, curr) => sum + curr, 0);
    count++;

    if (count > queue3.length * 1.5 - 2) return -1;
  }
  return count;
}

// js의 shift 메소드는 최대 O(n)의 시간 복잡도를 가지니까 큐를 사용할때는 이를 조심하자
// https://school.programmers.co.kr/learn/courses/30/lessons/118667#
