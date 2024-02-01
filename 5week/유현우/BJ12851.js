let [n, k] = "5 17".split(" ");
let max = 200000;

// 1초후 x-1 or x+1
// 1초후 2*x

// 3으로 나누어 떨어지게
let ans = new Array(max + 4).fill(0);
let vis = new Array(max + 4).fill(0);

const check = (start, end) => {
  let queue = [];
  vis[start] = 1;
  ans[start] = 1;
  queue.push(start);
  while (queue.length) {
    let cx = queue.shift();
    // n-1 n+1 n*2 경우가 총 3개
    for (let dir = 0; dir < 3; dir++) {
      let nx;
      if (dir === 0) {
        nx = cx * 2;
      } else if (dir === 1) {
        nx = cx + 1;
      } else {
        nx = cx - 1;
      }

      if (nx >= 0 && nx < max) {
        if (!vis[nx]) {
          queue.push(nx);
          // 시간대 방문을 위해서 + 1, 처음에 1이었으니까 2초때 방문 표기하기
          vis[nx] = vis[cx] + 1;
          ans[nx] += ans[cx];
        } else if (vis[nx] === vis[cx] + 1) {
          ans[nx] += ans[cx];
        }
      }
    }
  }
};

check(n, k);

// 1 -> 2(+1) -> 4(*2)->5(+1)->10(*2) 5가 아니라 4임
console.log(vis[k] - 1);
console.log(ans[k]);
