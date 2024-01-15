const file = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = require("fs").readFileSync(file).toString().trim().split("\n");

const [A, B, C] = input.shift().split(" ").map(Number);
const result = [];
console.log(solution(input));

function solution(input) {
    
    for (const range of input) {
        const [start, end] = range.split(" ").map(Number);
        initializeParkingCount(start, end);
    }
    return result.map(calculateFee).reduce((a, b) => a + b, 0);
}

function initializeParkingCount(start, end) {
    for (start+1; start < end; start++) {
        if(!result[start]) {
            result[start] = 0;
        }
        result[start]++;
    }
}

function calculateFee(count) {
    switch(count) {
        case 1:
            return count * A;
        case 2:
            return count * B;
        case 3:
            return count * C;
    }
}