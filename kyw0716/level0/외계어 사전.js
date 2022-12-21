const isSame = (arr1, arr2) => {
  arr1 = arr1.sort().join("");
  arr2 = arr2.sort().join("");

  return arr1 === arr2;
};

function solution(spell, dic) {
  let answer = false;

  dic = dic.map((d) => d.split(""));
  dic.forEach((d) => {
    if (isSame(d, spell)) answer = true;
  });

  return answer ? 1 : 2;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/120869
