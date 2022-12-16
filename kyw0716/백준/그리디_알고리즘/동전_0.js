const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

rl.on("line", (input) => {
  inputs.push(input);
  count++;

  if (count === parseInt(inputs[0].split(" ")[0], 10) + 1) rl.close();
}).on("close", () => {
  const coins = inputs
    .filter((v, i) => i > 0)
    .map((price) => parseInt(price, 10));
  let totalPrice = parseInt(inputs[0].split(" ")[1], 10);
  let coinCount = 0;

  for (let i = coins.length - 1; i >= 0; i--) {
    coinCount += Math.floor(totalPrice / coins[i]);
    totalPrice = totalPrice % coins[i];

    if (totalPrice === 0) break;
  }

  console.log(coinCount);
});
