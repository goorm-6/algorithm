const input = `3
0 1 0
0 0 1
1 0 0`.split("\n");

const N = +input.shift();

let arr = [];
input.map((item) => {
  let tmp = item.split(" ").map(Number);
  arr.push(tmp);
});

function solution(N, matrix) {
  for (let k = 0; k < N; k++) {
    for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
        if (matrix[i][k] && matrix[k][j]) {
          console.log(`i=${i} j=${j} k=${k}`);
          matrix[i][j] = 1;
        }
      }
    }
  }

  for (let i = 0; i < N; i++) {
    console.log(matrix[i].join(" "));
  }
}

solution(N, arr);
