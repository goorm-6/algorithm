const file = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = require("fs").readFileSync(file).toString().trim().split("\n");

function solution(input) {
    const [H, W] = input.shift().split(" ").map(Number);

    const result = Array.from(Array(H), () => Array(W).fill(-1));

    for (let i = 0; i < H; i++) {
        const clouds = input.shift().split("");
        let count = 0;
        for (let j = 0; j < W; j++) {
            if (clouds[j] === "c") {
                count = 0;
                result[i][j] = count++;
            }
            if (clouds[j] === "." && count > 0) {
                result[i][j] = count++;
            }
        }
    }
    return getFormat(result);
}

function getFormat(arr) {
    let result = arr.join("\n");
    return result.replaceAll(',', ' ');
}

console.log(solution(input));