const getYaksoo = (n) => {
  const yaksoo = [];

  for (let i = n; i >= 1; i--) {
    if (n % i === 0) yaksoo.push(i);
  }

  return yaksoo;
};

const getIsGiYak = (n) => {
  while (n % 5 === 0) {
    n /= 5;
  }

  while (n % 2 === 0) {
    n /= 2;
  }

  return n === 1;
};

function solution(a, b) {
  const aYaksoo = getYaksoo(a);
  const bYaksoo = getYaksoo(b);
  let maxCommonYaksoo;

  for (let i = 0; i < aYaksoo.length; i++) {
    if (bYaksoo.includes(aYaksoo[i])) {
      maxCommonYaksoo = aYaksoo[i];
      break;
    }
  }

  return getIsGiYak(b / maxCommonYaksoo) ? 1 : 2;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120878
