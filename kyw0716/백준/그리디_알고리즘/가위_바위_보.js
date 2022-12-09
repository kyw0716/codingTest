const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inputs = [];
let count = 0;

const winning = {
  S: "R",
  P: "S",
  R: "P",
};

const defeating = {
  S: "P",
  P: "R",
  R: "S",
};

const allForm = ["S", "P", "R"];

rl.on("line", (input) => {
  inputs.push(input);
  count++;

  if (count === parseInt(inputs[2]) + 3) rl.close();
}).on("close", () => {
  const rounds = parseInt(inputs.shift());
  const sangeun = inputs.shift().split("");
  const friendsCount = parseInt(inputs.shift());
  const friends = inputs.map((v) => v.split(""));

  let sangeunScore = 0;
  let perfectScore = 0;

  for (let i = 0; i < rounds; i++) {
    const counting = {
      S: 0,
      P: 0,
      R: 0,
    };
    let max = 0;

    for (let j = 0; j < friendsCount; j++) {
      if (sangeun[i] === friends[j][i]) sangeunScore++;
      if (winning[friends[j][i]] === sangeun[i]) sangeunScore += 2;
      counting[friends[j][i]]++;
    }

    allForm.forEach((form) => {
      const score = counting[form] + counting[defeating[form]] * 2;
      if (score > max) max = score;
    });

    perfectScore += max;
  }

  console.log(sangeunScore);
  console.log(perfectScore);
});
