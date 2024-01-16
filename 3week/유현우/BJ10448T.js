// const fs = require('fs');
// const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');
const input = `3
10
20
1000`.split('\n');

const tc = parseInt(input[0])
const nums = Array.from({ length: 45 }, (_, n) => n * (n + 1) / 2)

let possible = []
for (let n1 = 1; n1 <= 44; n1++) {
    for (let n2 = n1; n2 <= 44; n2++) {
        for (let n3 = n2; n3 <= 44; n3++) {
            let t = nums[n1] + nums[n2] + nums[n3]
            if (t <= 1000) {
                possible[t] = 1
            }
        }
    }
}
for (let t = 1; t <= tc; t++) {
    if (possible[Number(input[t])]) {
        console.log(1)
    } else {
        console.log(0)
    }
}