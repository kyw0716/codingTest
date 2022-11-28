function solution(babbling) {
  const patternDetectRegExp = /aya|ye|woo|ma/g;
  const duplicateDetectRegExp = /(aya){2,}|(ye){2,}|(woo){2,}|(ma){2,}/g;

  babbling = babbling.filter(
    (word) => word.match(patternDetectRegExp) !== null
  );
  babbling = babbling.filter(
    (word) => word.match(duplicateDetectRegExp) === null
  );
  babbling = babbling.filter(
    (word) => word.replace(patternDetectRegExp, "").length === 0
  );

  return babbling.length;
}

//https://school.programmers.co.kr/learn/courses/30/lessons/133499
