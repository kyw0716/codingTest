const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];

const whiteStart = "WBWBWBWB".split("");
const blackStart = "BWBWBWBW".split("");
const wBoard = Array(8)
  .fill(0)
  .map((v, i) => {
    if (i % 2 === 0) return whiteStart;
    return blackStart;
  });
const bBoard = Array(8)
  .fill(0)
  .map((v, i) => {
    if (i % 2 === 0) return blackStart;
    return whiteStart;
  });

let count = 0;

const compareBoard = (board) => {
  let wCount = 0;
  let bCount = 0;

  for (let i = 0; i < 8; i++) {
    for (let j = 0; j < 8; j++) {
      if (board[i][j] !== wBoard[i][j]) wCount += 1;
    }
  }
  for (let i = 0; i < 8; i++) {
    for (let j = 0; j < 8; j++) {
      if (board[i][j] !== bBoard[i][j]) bCount += 1;
    }
  }

  return Math.min(wCount, bCount);
};

rl.on("line", (input) => {
  inputs.push(input);
  count += 1;

  if (inputs[0].split(" ").map(Number)[0] + 1 === count) rl.close();
}).on("close", () => {
  const wh = inputs.shift().split(" ").map(Number);
  const board = inputs.map((v) => v.split(""));
  let min = 64;

  for (let i = 0; i <= wh[0] - 8; i++) {
    for (let j = 0; j <= wh[1] - 8; j++) {
      const currentBoard = board
        .filter((row, ri) => ri >= i && ri < 8 + i)
        .map((row, ri) => {
          return row.filter((col, ci) => ci >= j && ci < 8 + j);
        });
      const currentBoardChangeCount = compareBoard(currentBoard);
      if (currentBoardChangeCount < min) min = currentBoardChangeCount;
    }
  }

  console.log(min);
});
