const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (input) => {
  const inputString = input.split(/\+|\-/);

  console.log(inputString);
});
