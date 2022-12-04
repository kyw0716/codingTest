const getSalePrice = (price) => {
  if (price >= 500_000) return (80 / 100) * price;
  if (price >= 300_000) return (90 / 100) * price;
  if (price >= 100_000) return (95 / 100) * price;
  return price;
};

function solution(price) {
  return Math.floor(getSalePrice(price));
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120818
