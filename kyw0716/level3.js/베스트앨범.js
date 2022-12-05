const getMaxPlaySongs = (genre, number, songs) => {
  const sameGenreSongs = [];
  const result = [];

  number.forEach((n) => {
    if (songs[n][0] === genre) sameGenreSongs.push(n);
  });

  sameGenreSongs.sort((a, b) => songs[b][1] - songs[a][1]);

  for (let i = 0; i < 2; i++) {
    const number = sameGenreSongs.shift();
    if (number !== undefined) result.push(number);
  }

  return result;
};

function solution(genres, plays) {
  const songs = {};
  const playPerGenre = {};
  const number = [];
  const genreSet = [...new Set(genres)];
  let answer;

  for (let i = 0; i < genres.length; i++) {
    songs[i] = [genres[i], plays[i]];
    number.push(i);
  }

  for (let i = 0; i < genreSet.length; i++) {
    playPerGenre[genreSet[i]] = 0;
  }

  for (let i = 0; i < genres.length; i++) {
    playPerGenre[songs[i][0]] += songs[i][1];
  }

  genreSet.sort((a, b) => playPerGenre[b] - playPerGenre[a]);

  answer = genreSet.map((genre) => {
    return getMaxPlaySongs(genre, number, songs);
  });

  console.log(answer);

  answer = answer.reduce((acc, curr) => [...acc, ...curr], []);

  return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/42579
