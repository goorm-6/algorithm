const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, M] = input.shift().split(" ");
const bord = input.map(i => i.split(""));

const whiteBord = [
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
];

const blackBord = [
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
    "BWBWBWBW",
    "WBWBWBWB",
];

function whileBordCount(x, y) {
    let count = 0;
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (bord[y + i][x + j] !== whiteBord[i][j]) count++;
        }
    }
    return count;
}

function blackBordCount(x, y) {
    let count = 0;
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (bord[y + i][x + j] !== blackBord[i][j]) count++;
        }
    }
    return count;
}

const countArr = [];

for (let i = 0; i < N - 7; i++) {
    for (let j = 0; j < M - 7; j++) {
        countArr.push(whileBordCount(j, i));
        countArr.push(blackBordCount(j, i));
    }
}

console.log(Math.min(...countArr));
