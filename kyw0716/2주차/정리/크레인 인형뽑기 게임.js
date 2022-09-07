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

// https://school.programmers.co.kr/learn/courses/30/lessons/64061
// array.at(-1)을 통해 배열의 마지막 요소에 접근할 수 있다.
