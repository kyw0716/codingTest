function solution(board, moves) {
  let answer = 0;
  let stack = [];

  moves.forEach((columnNumber) => {
    for (let i = 0; i < board.length; i++) {
      if (board[i][columnNumber - 1] !== 0) {
        if (board[i][columnNumber - 1] === stack.at(-1)) {
          stack.pop();
          answer += 2;
          board[i][columnNumber - 1] = 0;
          break;
        }
        stack.push(board[i][columnNumber - 1]);
        board[i][columnNumber - 1] = 0;
        break;
      }
    }
  });
  return answer;
}
