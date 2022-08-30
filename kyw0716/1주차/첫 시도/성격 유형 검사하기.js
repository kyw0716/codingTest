function solution(survey, choices) {
  var answer = "";

  let result = {
    RT: {
      R: 0,
      T: 0,
    },
    CF: {
      C: 0,
      F: 0,
    },
    JM: {
      J: 0,
      M: 0,
    },
    AN: {
      A: 0,
      N: 0,
    },
  };

  const calculateResult = (alphabet, score) => {
    if (alphabet === "R" || alphabet === "T") {
      result.RT[alphabet] += score;
    } else if (alphabet === "C" || alphabet === "F") {
      result.CF[alphabet] += score;
    } else if (alphabet === "J" || alphabet === "M") {
      result.JM[alphabet] += score;
    } else if (alphabet === "A" || alphabet === "N") {
      result.AN[alphabet] += score;
    }
  };

  for (let i = 0; i < survey.length; i++) {
    if (choices[i] > 4) {
      calculateResult(survey[i].slice(1), choices[i] - 4);
    } else if (choices[i] < 4) {
      calculateResult(
        survey[i].replace(survey[i].slice(1), ""),
        4 - choices[i]
      );
    }
  }

  if (result.RT.R >= result.RT.T) {
    answer += "R";
  } else {
    answer += "T";
  }

  if (result.CF.C >= result.CF.F) {
    answer += "C";
  } else {
    answer += "F";
  }

  if (result.JM.J >= result.JM.M) {
    answer += "J";
  } else {
    answer += "M";
  }

  if (result.AN.A >= result.AN.N) {
    answer += "A";
  } else {
    answer += "N";
  }

  return answer;
}
