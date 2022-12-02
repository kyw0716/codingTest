function getIsBombNearBy(board, i, j) {
  for (let c = -1; c < 2; c++) {
    for (let r = -1; r < 2; r++) {
      if (c === 0 && r === 0) continue;
      if (
        i + c < 0 ||
        i + c > board.length - 1 ||
        j + r < 0 ||
        j + r > board.length - 1
      )
        continue;
      if (board[i + c][j + r] === 1) return true;
    }
  }
}

function solution(board) {
  var answer = 0;

  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      if (getIsBombNearBy(board, i, j) && board[i][j] !== 1) board[i][j] = 2;
    }
  }

  board.forEach((b) => {
    answer += b.filter((v) => v === 0).length;
  });

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120866
