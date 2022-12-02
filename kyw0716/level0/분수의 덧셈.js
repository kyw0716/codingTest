function getLCM(num1, num2) {
  const divisors1 = [];
  const divisors2 = [];
  let same;
  let max;

  for (let i = 1; i <= num1; i++) {
    if (num1 % i === 0) divisors1.push(i);
  }

  for (let i = 1; i <= num2; i++) {
    if (num2 % i === 0) divisors2.push(i);
  }

  same = divisors1.filter((v) => divisors2.includes(v));
  max = Math.max(...same);

  return max * (num1 / max) * (num2 / max);
}

function divide(denum, LCM) {
  let min = Math.min(denum, LCM);

  for (let i = 2; i <= min; i++) {
    if (denum % i === 0 && LCM % i === 0) {
      denum = denum / i;
      LCM = LCM / i;
      i = 1;
      min = Math.min(denum, LCM);
    }
  }

  return [denum, LCM];
}

function solution(denum1, num1, denum2, num2) {
  const LCM = getLCM(num1, num2);
  const denum = (denum1 * LCM) / num1 + (denum2 * LCM) / num2;
  const [up, down] = divide(denum, LCM);

  return [up, down];
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120808
