function solution(survey, choices) {
  let answer = "";
  let character = ["RT", "CF", "JM", "AN"];
  let score = [0, 0, 0, 0];

  for (let i = 0; i < survey.length; i++) {
    if (!character.includes(survey[i])) {
      survey[i] = `${survey[i][1]}${survey[i][0]}`;
      choices[i] = choices[i] + 6 - 2 * (choices[i] - 1);
    }
  }
  for (let i = 0; i < survey.length; i++) {
    switch (survey[i]) {
      case "RT":
        score[0] += choices[i] - 4;
        break;
      case "CF":
        score[1] += choices[i] - 4;
        break;
      case "JM":
        score[2] += choices[i] - 4;
        break;
      case "AN":
        score[3] += choices[i] - 4;
        break;
    }
  }
  for (let i = 0; i < 4; i++) {
    answer += `${score[i] <= 0 ? character[i][0] : character[i][1]}`;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
