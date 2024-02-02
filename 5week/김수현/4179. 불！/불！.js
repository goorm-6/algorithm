const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const dx = [-1, 1, 0, 0];
const dy = [0, 0, -1, 1];

const [r, c] = input.shift().split(' ').map(Number);
const map = input.map((x) => x.split("")); //미로 지도
const fires = []; //불의 위치 저장하는 배열
let [sy, sx] = [0, 0]; //지훈이 시작 위치
let answer = -1;

//지훈이의 bfs 방문 처리 배열
const visited = Array.from(new Array(r), () => new Array(c).fill(false));

// 시간대별 불 위치 저장하는 불 방문 처리 배열
const fireMap = Array.from(new Array(r), () => new Array(c).fill(Infinity));

for (let y = 0; y < r; y++) {
   for (let x = 0; x < c; x++) {
      if (map[y][x] === "F") fires.push([y, x, 0]); // 불의 위치와 시간0 저장
      else if (map[y][x] === "J") [sy, sx] = [y, x]; // 지훈이의 위치 저장
   }
}

// 바로 탈출 가능한 경우 => 지훈이가 이미 가장 자리에 있음 =>  1 출력 후 종료
if (sy === 0 || sy === r-1 || sx === 0 || sx === c-1) {
   console.log(1);
   return;
}
// 불의 위치가 없는 경우를 확인
if (fires.length > 0) fireBfs();
bfs();

console.log(answer !== -1 ? answer : "IMPOSSIBLE");

// 불 bfs
function fireBfs() {
   fires.forEach((el) => {
      const [y, x, _] = el;
      fireMap[y][x] = 0; // 각 위치에서 불이 도착하는 시간 저장하는 배열
   });

   while (fires.length) {
      const [y, x, cnt] = fires.shift(); // fires배열을 큐처럼 사용

      // 상하좌우 네 방향에 대해 수행
      for (let i = 0; i < 4; i++) {
         const [ny, nx] = [y + dy[i], x + dx[i]]; // 현재 위치

         if(ny < 0 || nx < 0 || ny >= r || nx >= c) continue; // 미로의 경계를 벗어나는 경우
         if (map[ny][nx] === "#" || fireMap[ny][nx] <= cnt + 1) continue; // 벽이거나 불이 더 빨리 도달한 경우

         fireMap[ny][nx] = cnt + 1; //현재 위치까지 걸린 시간 + 1
         fires.push([ny, nx, cnt+1]); // 위치와 시간을 fires 큐에 추가
      }
   }
}

// 지훈이의 탈출 bfs
function bfs() {
   const q = [[sy, sx, 0]];
   visited[sy][sx] = true;

   // 큐에 요소가 있는 동안 계속 실행
   while(q.length) {
      const [y, x, cnt] = q.shift();

      for(let i = 0; i < 4; i++){
         const [ny, nx] = [y + dy[i], x + dx[i]];
         const next_cnt = cnt + 1;

         // 벽, 불 이 있거나 이미 방문한 경우
         if(map[ny][nx] === "#" || map[ny][nx] === "F" || visited[ny][nx])
            continue;

         // 해당 위치에 불이 도달한 시간이 지훈이가 도달하는 시간보다 작거나 같은 경우
         if(fireMap[ny][nx] <= next_cnt) continue;

         // 미로의 가장자리에 도달하면 탈출함
         if(ny === 0 || ny === r-1 || nx === 0 || nx === c-1) {
            answer = next_cnt + 1;
            return;
         }

         // 방문했음을 표시하고 해당 위치와 시간을 큐에 추가
         visited[ny][nx] = true;
         q.push([ny, nx, next_cnt]);
      }
   }
}