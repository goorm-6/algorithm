const file = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = require("fs").readFileSync(file).toString().trim().toUpperCase().split("");

console.log(solution(input));

function solution(input) {
    const result = {};
    for (const c of input) {
        if(!result[c]) {
            result[c] = 0;
        }
        result[c]++;
    }

    const maxCount = getMaxCount(Object.values(result));
    const test =  Object.entries(result).filter(([_, value]) => value === maxCount);
    return test.length > 1 ? '?' : test[0][0];
}

function getMaxCount(values) {
    const sort =  values.sort((a, b) => b - a);
    return sort[0];
}