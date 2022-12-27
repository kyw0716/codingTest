const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const afterRound = (player) => {
  if (player % 2 === 0) {
    return player / 2;
  }
  return (player + 1) / 2;
};

rl.on("line", (input) => {
  let [round, kim, lim] = input.split(" ").map(Number);
  let count = 1;

  while (Math.abs(kim - lim) !== 1 || Math.max(kim, lim) % 2 !== 0) {
    kim = afterRound(kim);
    lim = afterRound(lim);
    count += 1;
  }

  console.log(count);
});
