const file = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = require("fs").readFileSync(file).toString().split("\n");

const [N, H] = input.shift().split(" ").map(Number);
const nums = input.map(Number);

//첫 번째 장애물은 항상 석순이고, 그 다음에는 종유석과 석순이 번갈아가면서 등장한다.
const S = Array.from({ length: H + 1 }, () => 0);
const J = Array.from({ length: H + 1 }, () => 0);

for (let i = 0; i < N; i++) {
    if (i % 2 === 0) {
      S[nums[i]]++;
    } else {
      J[nums[i]]++;
    }
  }

for (let i = H; i > 1; i--) {
    S[i - 1] = S[i] + S[i - 1];
    J[i - 1] = J[i] + J[i - 1];
}

let min = Infinity; //Number.MAX_VALUE;
let count = 0;

for (let i = 1; i <= H; i++) {
    const obstacle = S[i] + J[H + 1 - i];
    if (obstacle < min) {
        min = obstacle;
        count = 1;
    }
    else if (min == obstacle) {
        count++;
    }
}

console.log(min, count);