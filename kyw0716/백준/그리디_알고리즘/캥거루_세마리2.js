const readline = require("readline");
const r1 = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

r1.on("line", (input) => {
  const k = input.split(" ");
  const max = Math.max(k[2] - k[1] - 1, k[1] - k[0] - 1);

  console.log(max);
});
