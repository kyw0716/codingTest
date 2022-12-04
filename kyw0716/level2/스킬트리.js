function solution(skill, skill_trees) {
  let skillArray = skill.split("");
  let skillTreesArray = skill_trees.map((skillTree) => skillTree.split(""));
  let answer = 0;

  skillTreesArray = skillTreesArray.map((skillTree) => {
    return skillTree
      .filter((skill) => skillArray.includes(skill))
      .map((skill) => {
        return skillArray.indexOf(skill);
      });
  });

  for (let i = 0; i < skillTreesArray.length; i++) {
    let isCorrect = true;

    for (let j = 0; j < skillTreesArray[i].length; j++) {
      if (skillTreesArray[i][j] !== j) {
        isCorrect = false;
        break;
      }
    }

    if (isCorrect) answer++;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/49993
