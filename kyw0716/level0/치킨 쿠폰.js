function solution(chicken) {
  let bonusChicken = 0;

  while (Math.floor(chicken / 10) > 0) {
    const bonus = Math.floor(chicken / 10);
    bonusChicken += bonus;
    chicken = chicken % 10;
    chicken += bonus;
  }

  return bonusChicken;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120884
