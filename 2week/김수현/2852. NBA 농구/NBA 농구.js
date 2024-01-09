const fs = require('fs');
const [N, ...input] = fs.readFileSync("./dev/stdin").toString().trim().split("\n")

let one = 0;
let two = 0;
let score = [];
let answer = [0, 0];

input.forEach(v => {
  let [team, t] = v.split(' ');
  let [mm, ss] = t.split(':')
  team == 1 ? one++ : two++;
  
  let time = Number(mm) * 60 + Number(ss);
  if (one > two) {
    score.push([1, time])
  } else if (two > one) {
    score.push([2, time])
  } else {
    score.push([0, time])
  }
})

score.push([0, 2880])

for (let i = 1; i < score.length; i++) {
  if (score[i - 1][0] != 0)
    answer[score[i - 1][0] - 1] += score[i][1] - score[i - 1][1];
}

answer = answer.map(v => {
  let mm = String(Math.floor(v / 60)).padStart(2, '0')
  let ss = String(v % 60).padStart(2, '0');
  return `${mm}:${ss}`
}).join('\n')

console.log(answer)