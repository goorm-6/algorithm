//https://www.acmicpc.net/problem/1189
const input = `3 4 6
....
.T..
....`.split('\n');

const [R, C, K] = input.shift().split(" ").map(Number);
// 상 하 좌 우
let dx = [0, 0, -1, 1];
let dy = [1, -1, 0, 0];
// K가 몇번 나오는지 count 개수 (처음에 0으로 설정)
let result = 0;

let arr = [];
for (let i = 0; i < R; i++) {
    arr.push(input.shift().split(''));
}

// 깊이 우선 탐색으로 도착지 찍고 움직인 곳은 T로 메모리 스택에서 나올 때 .으로 바꿔주기
function dfs(x, y, cnt) {
    // 도착지는 오른쪽 끝이기 때문에 C - 1 하면 x축 y 는 y축을 뜻한다. 총 움직인 횟수가 K면 result 값을 1 증가.
    if (x === C - 1 && y === 0 && cnt === K) {
        console.log("도착~_~", `cnt=${cnt} x=${x}, y=${y}`);
        result += 1;
    } 
    else {
        // arr[y][x]는 이번에 움직이는 칸이기 때문에 T로 설정한다.
        console.log("else문 T 입력 전", x, y, arr[y][x], `cnt=${cnt}`);
        arr[y][x] = 'T';
        console.log("else문 T 입력 후", x, y, arr[y][x], `cnt=${cnt}`);

        // 상 하 좌 우로 움직일거임
        for (let d = 0; d < 4; d++) {
            let nx = x + dx[d];
            let ny = y + dy[d];

            // nx < 0 || ny < 0 || nx >= C || ny >= R는 ArrayIndexOutOfBoundsException을 일으키는 요소기 때문에 필터링 (즉 벽을 넘은 값들)
            if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

            // 지금 위치에서 상 하 좌 우로 반복문을 돌건데 처음이라고 가정하면 상이 '.'인지 즉 움직일 수 있는 칸이면 if문 안으로 들어옴
            if (arr[ny][nx] === '.') {
                // 위쪽을 탐색한거기 때문에 움직이는 칸처럼 이동했다는 것을 표시 다시는 못오게
                console.log("안쪽 if문 T 입력 전", nx, ny, arr[ny][nx], `cnt=${cnt}`);
                arr[ny][nx] = 'T';
                console.log("안쪽 if문 T 입력 후", nx, ny, arr[ny][nx], `cnt=${cnt}`);
                // 체크한 상태로 위쪽으로 움직인 위치로 다시 처음부터 탐색함
                dfs(nx, ny, cnt + 1);
                // 위쪽으로 탐색했으니까 다시 원래대로 돌리고 다음에 밑으로 돌고 좌 -> 우로 반복하면서 최종 목적지를 찍으면 계속 리턴하는 방식으로 모든 함수가 호출이 종료되면 K번으로 도착한 횟수가 result에 찍힌다.
                console.log(nx, ny, "초기화");
                arr[ny][nx] = '.';
            }
        }
    }
}

// 처음 움직이는 위치가 왼쪽 아래이기 때문에 x좌표는 0 y좌표는 맨밑으로 하기위해서 R - 1이다. count가 1인 이유는 처음 시작하는 위치를 세고 시작하기 때문
dfs(0, R - 1, 1);
console.log(result);