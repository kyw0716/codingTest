function solution(n, words) {
  let answer = [0, 0];
  // 구해야 하는 것
  // 누가 탈락했는지 (탈락자 없으면 0)
  // 자신의 몇번째 차례에 탈락했는지 (탈락자 없으면 0)

  // 누가 탈락했는지는 잘못된 단어의 index를 n으로 나눈 나머지에 1을 더해서 구하자
  // 몇번째 차례인지는 잘못된 단어의 index를 n으로 나눈 몫을 통해 구하자

  // 탈락 규칙
  // 한자리 단어
  // 앞의 단어와 연결되지 않는 단어
  // 한번 사용되었던 단어

  for (let i = 1; i < words.length; i++) {
    // 단어가 한 자리일 때
    if (words[i].length === 1) {
      answer[0] = (i % n) + 1;
      answer[1] = Math.floor(i / n) + 1;
      break;
    }
    // 앞의 단어와 연결되지 않을 때
    if (words[i - 1].at(-1) !== words[i].at(0)) {
      answer[0] = (i % n) + 1;
      answer[1] = Math.floor(i / n) + 1;
      break;
    }
    // 이전에 등장했던 단어를 사용했을 때
    if (words.slice(0, i).includes(words[i])) {
      answer[0] = (i % n) + 1;
      answer[1] = Math.floor(i / n) + 1;
      break;
    }
  }
  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/12981
