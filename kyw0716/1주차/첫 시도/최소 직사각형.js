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
