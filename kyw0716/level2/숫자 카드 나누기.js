const getYaksoo = (value) => {
  let yaksoo = [];

  for (let i = 1; i <= Math.sqrt(value); i++) {
    if (value % i === 0) {
      yaksoo.push(i);

      if (i !== value / i) yaksoo.push(value / i);
    }
  }

  yaksoo = [...new Set(yaksoo)].sort((a, b) => a - b);

  return yaksoo;
};

function solution(arrayA, arrayB) {
  let max;
  let canDivideAllA = [];
  let canDivideAllB = [];
  let finalA = [0];
  let finalB = [0];
  let A = getYaksoo(arrayA[0]);
  let B = getYaksoo(arrayB[0]);

  for (let i = 0; i < A.length; i++) {
    let isCorrect = true;

    for (let j = 0; j < arrayA.length; j++) {
      if (arrayA[j] % A[i] !== 0) {
        isCorrect = false;
        break;
      }
    }

    if (isCorrect) canDivideAllA.push(A[i]);
  }

  for (let i = 0; i < B.length; i++) {
    let isCorrect = true;

    for (let j = 0; j < arrayB.length; j++) {
      if (arrayB[j] % B[i] !== 0) {
        isCorrect = false;
        break;
      }
    }

    if (isCorrect) canDivideAllB.push(B[i]);
  }

  for (let i = 0; i < canDivideAllA.length; i++) {
    let isCorrect = true;

    for (let j = 0; j < arrayB.length; j++) {
      if (arrayB[j] % canDivideAllA[i] === 0) {
        isCorrect = false;
        break;
      }
    }

    if (isCorrect) finalA.push(canDivideAllA[i]);
  }

  for (let i = 0; i < canDivideAllB.length; i++) {
    let isCorrect = true;

    for (let j = 0; j < arrayA.length; j++) {
      if (arrayA[j] % canDivideAllB[i] === 0) {
        isCorrect = false;
        break;
      }
    }

    if (isCorrect) finalB.push(canDivideAllB[i]);
  }

  return Math.max(...finalA, ...finalB);
}

// arrayA의 모든 원소 중 첫 번째 수의 약수를 구해 A 배열로 만든다.
// A배열의 값으로 arrayA의 다른 요소들을 나누어 모두 나눌 수 있는 값만을 canDivideAllA에 저장한다.

// arrayA의 모든 원소 중 첫 번째 수의 약수를 구해 A 배열로 만든다.
// A배열의 값으로 arrayA의 다른 요소들을 나누어 모두 나눌 수 있는 값만을 canDivideAllB에 저장한다.

// canDivideAllA의 원소들로 arrayB를 모두 나눠본다.
// arrayB의 모든 원소를 나눌 수 없는 가장 큰 원소를 찾는다.

// canDivideALlB의 원소들로 arrayA를 모두 나눠본다.
// arrayA의 모든 원소를 나눌 수 없는 가장 큰 원소를 찾는다.

// 앞에서 찾은 두 값을 비교해 더 큰값을 반환한다.

// https://school.programmers.co.kr/learn/courses/30/lessons/135807#
