function solution(sizes) {
  let maxWidth = 0;
  let maxHeight = 0;
  sizes.map((card) => {
    if (card[0] < card[1]) card.reverse();
    maxWidth = Math.max(maxWidth, card[0]);
    maxHeight = Math.max(maxHeight, card[1]);
  });
  return maxWidth * maxHeight;
}

// 도형 관련이면 일단 머릿속으로 생각부터 해보자.
// https://school.programmers.co.kr/learn/courses/30/lessons/86491
