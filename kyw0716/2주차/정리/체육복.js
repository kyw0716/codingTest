function solution(n, lost, reserve) {
  // 체육복을 도난당한 학생의 번호들에서 1을 빼거나 더한 번호를 찾는다.
  // 해당 번호의 학생이 체육복 여벌을 갖고 있다면 lost에서 도난당한 학생의 번호를 빼고,
  // reserve에서 여벌의 체육복을 가지고 있는 학생의 번호도 뺀다.
  lost.sort((a, b) => a - b);
  reserve.sort((a, b) => a - b);
  lost = lost.filter((number) => {
    if (reserve.includes(number)) {
      reserve = reserve.filter((reserveNumber) => reserveNumber !== number);
      return false;
    }
    return true;
  });
  lost = lost.filter((number) => {
    {
      if (reserve.includes(number - 1)) {
        reserve = reserve.filter(
          (reserveNumber) => reserveNumber !== number - 1
        );
        return false;
      }
      if (reserve.includes(number + 1)) {
        reserve = reserve.filter(
          (reserveNumber) => reserveNumber !== number + 1
        );
        return false;
      }
      return true;
    }
  });
  return n - lost.length;
}

// 문제 잘 읽어보고 풀자... 대충 이해하고 풀었다가 시도 겁나게 했잖아 ㅠㅠ
// https://school.programmers.co.kr/learn/courses/30/lessons/42862
