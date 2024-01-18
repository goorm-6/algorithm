const input = require('fs').readFileSync('/dev/stdin').toString().trim().split('\n');
const [N, M] = input.shift().split(' ').map( x => Number(x));
const board = input.map( x => x.split(''));

let answer = [];
const line = ['WBWBWBWB', 'BWBWBWBW'];

for (let i = 0; i <= N - 8; i++) { //행
   for (let j = 0; j <= M - 8; j++) { //열
      
      for (let z = 0; z < 2; z++) { //1. 하양 먼저 체스판 검사  2. 검정 먼저 체스판 검사
         let count = 0;
   
         for (let x = 0; x < 8; x++) { //행
            for (let y = 0; y < 8; y++) { //열
               if (board[i + x][j + y] !== line[(x + z) % 2][y]) { 
                  count++;
               } 
            }
         }
         answer.push(count);
      }
   }
}

console.log(Math.min(...answer));