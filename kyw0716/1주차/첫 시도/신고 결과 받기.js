function solution(id_list, report, k) {
  let answer = new Array(id_list.length).fill(0);
  let reportFreq = new Array(id_list.length).fill(0);
  let stoppedUser = [];
  report = [...new Set(report)];
  for (let i = 0; i < report.length; i++) {
    report[i] = report[i].split(" ");
  }
  for (let i = 0; i < id_list.length; i++) {
    for (let j = 0; j < report.length; j++) {
      if (report[j][1] === id_list[i]) reportFreq[i]++;
    }
  }
  for (let i = 0; i < id_list.length; i++) {
    if (reportFreq[i] >= k) stoppedUser.push(id_list[i]);
  }
  console.log(stoppedUser);
  for (let i = 0; i < id_list.length; i++) {
    for (let j = 0; j < report.length; j++) {
      if (report[j][0] === id_list[i] && stoppedUser.includes(report[j][1]))
        answer[i]++;
    }
  }

  return answer;
}
