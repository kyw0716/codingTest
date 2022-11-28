const sortBysize = (a, b) => {
  return a - b;
};

function solution(k, tangerine) {
  let answer = 0;
  let sameSizeGroup = {};
  let size;

  tangerine.sort(sortBysize);
  size = [...new Set(tangerine)];

  for (let i = 0; i < tangerine.length; i++) {
    if (sameSizeGroup[`${tangerine[i]}`] !== undefined) {
      sameSizeGroup[`${tangerine[i]}`]++;
      continue;
    }
    sameSizeGroup[`${tangerine[i]}`] = 1;
  }

  size.sort((a, b) => {
    return sameSizeGroup[b] - sameSizeGroup[a];
  });

  for (let i = 0; i < size.length; i++) {
    answer++;
    k -= sameSizeGroup[size[i]];

    if (k <= 0) break;
  }

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/138476
