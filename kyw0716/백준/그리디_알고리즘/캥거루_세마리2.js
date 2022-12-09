const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const k = input.split(" ");
  const max = Math.max(k[2] - k[1] - 1, k[1] - k[0] - 1);

  console.log(max);
});
