function solution(keyinput, board) {
  const answer = [0, 0];
  const maxWidth = Math.floor(board[0] / 2);
  const maxHeight = Math.floor(board[1] / 2);

  keyinput.forEach((key) => {
    if (key === "left" && answer[0] - 1 >= -maxWidth) answer[0] -= 1;
    if (key === "right" && answer[0] + 1 <= maxWidth) answer[0] += 1;
    if (key === "down" && answer[1] - 1 >= -maxHeight) answer[1] -= 1;
    if (key === "up" && answer[1] + 1 <= maxHeight) answer[1] += 1;
  });

  return answer;
}

//https://school.programmers.co.kr/learn/courses/30/lessons/120861
