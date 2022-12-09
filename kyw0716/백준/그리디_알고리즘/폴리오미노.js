const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  let board = input;

  board = board.replace(/XXXX/g, "AAAA");
  board = board.replace(/XX/g, "BB");

  if (board.match(/X/) === null) console.log(board);
  else console.log("-1");
});
