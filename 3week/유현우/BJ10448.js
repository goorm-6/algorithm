const input = `3
10
20
1000`.split('\n').slice(1,).map(Number);

const TRI_LIST = [];
for (let i = 1; i < 45; i++) {
    TRI_LIST.push(i * (i + 1) / 2);
}

console.log(solution(input));

function solution(input) {
    const result = [];
    for (number of input) {
        result.push(findNumber(number));
    }
    return result.join('\n');
}

function findNumber(number) {
    for (i of TRI_LIST) {
        for (j of TRI_LIST) {
            for (k of TRI_LIST) {
                if (i + j + k === number) {
                    return 1;
                }
            }
        }
    }
    return 0;
}