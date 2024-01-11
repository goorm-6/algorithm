const fs = require('fs');
const input = fs.readFileSync("./dev/stdin").toString().trim().split('\n').map(v => v.split(' ').map(Number));
const [A, B, C] = input.shift();

let time = new Array(100).fill(0);
let answer = 0;
input.forEach(v => {
    let [start, end] = v;
    for (let x=start; x<end; x++){
        time[x]++;
    }
})

time.forEach(v => {
    if (v == 1){
        answer += A;
    } else if (v == 2){
        answer += B * 2;
    } else if (v == 3){
        answer += C * 3;
    }
})

console.log(answer);