const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [r, c] = input[0].split(' ').map(Number);
// 알파벳 보드 생성
const board = [];
for (let i = 1; i <= r; i++) board.push(input[i]);

// 싱하좌우
const dx = [0, 0, 1, -1];
const dy = [1, -1, 0, 0];
const visited = new Array(26).fill(false); // 알파벳(A-Z) 26개 방문 여부
let maxDepth = 0; // 최대 깊이

function dfs(depth, x, y) {
  // 현재 깊이가 최대 깊이보다 크면 최대 깊이를 갱신
  maxDepth = Math.max(maxDepth, depth); 

  // 상하좌우 4개 방향 이동
  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    // 범위 벗어나거나 이미 방문한 경우 무시
    if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
    if (visited[board[nx][ny].charCodeAt() - 65]) continue;

    // 방문하지 않은 알파벳을 만나면, 방문 처리
    visited[board[nx][ny].charCodeAt() - 65] = true;
    dfs(depth + 1, nx, ny); // 다음 칸에 대하여 dfs 재귀 호출
    // 백트래킹 - 현재 방문했던 칸에 대해서 다시 방문 false 로 갱신
    visited[board[nx][ny].charCodeAt() - 65] = false;
  }
}

// ASCII 코드(A:65) 변환 -> 인덱스(0)
visited[board[0][0].charCodeAt() - 65] = true; // 시작 위치의 알파벳을 방문으로 처리
dfs(1, 0, 0);

console.log(maxDepth);